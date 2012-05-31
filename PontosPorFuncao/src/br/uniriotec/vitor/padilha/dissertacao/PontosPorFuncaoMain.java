package br.uniriotec.vitor.padilha.dissertacao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;
import br.uniriotec.vitor.padilha.dissertacao.jaxb.MyValidationEventHandler;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.utils.UtilsArquivo;
import br.uniriotec.vitor.padilha.dissertacao.view.IFunctionPointView;
import br.uniriotec.vitor.padilha.dissertacao.view.SystemOutFunctionPointView;
import br.uniriotec.vitor.padilha.dissertacao.view.TextFunctionPointView;

public class PontosPorFuncaoMain {

	/**
	 * @param args
	 * @throws JAXBException 
	 */
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(FunctionPointSystem.class);
		
//		FunctionsPointSystem functionsPointSystem = new FunctionsPointSystem();
//		
//		DataModel dataModel = new DataModel();
//		
//		EIF eif1 = new EIF();
//		EIF eif2 = new EIF();
//		functionsPointSystem.setDataModel(dataModel);
//		dataModel.setEifs(new ArrayList<EIF>());
//		dataModel.getEifs().add(eif1);
//		dataModel.getEifs().add(eif2);
//		dataModel.setIlfs(new ArrayList<ILF>());
//		ILF ilf1 = new ILF();
//		ilf1.setName("teste-ilf");
//		ilf1.setSubsets(new ArrayList<Subset>());
//		Subset subset = new Subset();
//		subset.setName("teste-subset");
//		ilf1.getSubsets().add(subset);
//		subset.setFields(new ArrayList<Field>());
//		Field field = new Field();
//		field.setName("f1");
//		subset.getFields().add(field);
//		dataModel.getIlfs().add(ilf1);
//		
//
//		TransactionModel transactionModel= new TransactionModel();
//		
//		Transaction transaction = new Transaction();
//		transaction.setFtrList(new ArrayList<FTR>());
//		
//		FTR ftr1 = new FTR();
//		
//		ftr1.setName("a");
//		
//		ftr1.setUseAllFields(false);
//		
//		ftr1.setFields(new ArrayList<FTRField>());
//		
//		FTRField ftrField1 = new FTRField();
//		
//		ftr1.getFields().add(ftrField1);
//		
//		transaction.getFtrList().add(ftr1);
//		
//		transaction.setName("teste");
//		
//		transaction.setDependencies(new ArrayList<Dependency>());
//		Dependency dependency = new Dependency();
//		
//		dependency.setRef("aa");
//		
//		
//		transaction.getDependencies().add(dependency);
//		
//		transactionModel.setTransactions(new ArrayList<Transaction>());
//		
//		transactionModel.getTransactions().add(transaction);
//		
//		functionsPointSystem.setTransactionModel(transactionModel);
//		
		Marshaller m = context.createMarshaller();
//
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//	        m.marshal(functionsPointSystem, System.out);
		Unmarshaller um = context.createUnmarshaller();
		um.setEventHandler(new MyValidationEventHandler());

		Object obj = um.unmarshal(new File("resources/teste.xml"));

		IFunctionPointView functionPointView = new TextFunctionPointView();
		IFunctionPointView systemOutFunctionPointView = new SystemOutFunctionPointView();

		FunctionPointSystem functionPointSystem = (FunctionPointSystem) obj;
		FunctionPointCalculator functionPointCalculator = new FunctionPointCalculator();
		functionPointCalculator.getFunctionsView().add(functionPointView);
		functionPointCalculator.getFunctionsView().add(systemOutFunctionPointView);
		
		try {
			if(functionPointSystem.validate()) {
				if(functionPointSystem.getTransactionModel()!=null) {
					UtilsArquivo.salvar("resources/grafo.xdot", functionPointSystem.getTransactionModel().doDot(), false);
				}
				List<Transaction> transactions= new ArrayList<Transaction>(functionPointSystem.getTransactionModel().getTransactions());
				for(Transaction transaction:transactions){
					if(transaction.getName().equals("IncluirMotivoDeTransferencia") 
							|| 	transaction.getName().equals("RemoverMotivoDeTransferencia")
							|| 	transaction.getName().equals("AlterarMotivoDeTransferencia")
							|| 	transaction.getName().equals("ConsultarMotivosDeTransferencia")
							) {
						functionPointSystem.getTransactionModel().getTransactions().remove(transaction);
					}
				}
				functionPointSystem.clear();
				functionPointCalculator.calculate(functionPointSystem);

			}
		} catch (ElementException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	

}
