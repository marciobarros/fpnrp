package br.uniriotec.vitor.padilha.dissertacao;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;
import br.uniriotec.vitor.padilha.dissertacao.utils.UtilsArquivo;
import br.uniriotec.vitor.padilha.dissertacao.view.SystemOutFunctionPointView;

public class PontosPorFuncaoParser {

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

		Object obj = um.unmarshal(new File("resources/teste.xml"));

		SystemOutFunctionPointView functionPointView = new SystemOutFunctionPointView();

		FunctionPointSystem functionPointSystem = (FunctionPointSystem) obj;
		FunctionPointCalculator functionPointCalculator = new FunctionPointCalculator(functionPointView);
		try {
			if(functionPointSystem.validate()) {
				
				functionPointCalculator.calculate(functionPointSystem);
				
				if(functionPointSystem.getTransactionModel()!=null) {
					UtilsArquivo.salvar("resources/grafo.xdot", functionPointSystem.getTransactionModel().doDot(), false);
				}
			}
		} catch (ElementException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	

}
