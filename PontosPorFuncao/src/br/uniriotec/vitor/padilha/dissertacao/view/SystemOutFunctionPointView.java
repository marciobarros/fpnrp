package br.uniriotec.vitor.padilha.dissertacao.view;

import java.util.List;

import br.uniriotec.vitor.padilha.dissertacao.Complexity;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;

public class SystemOutFunctionPointView extends GenericFunctionPointView{

	@Override
	public void renderTransactionModelValue(TransactionModel transactionModel,
			int totalTransations, int totalFunctionsPoint) {
		System.out.println("**** Total de pontos por função não ajustado para transações: "+totalFunctionsPoint+" para "+totalTransations+" transações");

		
	}

	@Override
	public void addTransactionValue(Transaction transaction, String[] ftrs,
			String[] dets, Complexity complexity, int totalFunctionsPoint) {
		System.out.println("*** "+transaction.getType().name()+" - "+transaction.getName());
		System.out.println("**** FTRS:");
		for(int a=0;a<ftrs.length;a++){
			System.out.println("***** "+ftrs[a]);
		}
		System.out.println("**** DETS:");
		for(int a=0;a<dets.length;a++){
			System.out.println("***** "+dets[a]);
		}
		System.out.println("*** Valor de pontos por função: "+totalFunctionsPoint);
		System.out.println("*** FIM-"+transaction.getName());
		
	}

	@Override
	public void renderDataModelValue(DataModel dataModel,
			int totalDataModelElement, int totalFunctionsPoint) {
		System.out.println("**** Total de pontos por função não ajustado para função de dados: "+totalFunctionsPoint+" para "+totalDataModelElement+" arquivos");
	}

	@Override
	public void addDataModelElementValue(DataModelElement dataModelElement,
			List<String[]> rets, String[] dets, Complexity complexity, int totalFunctionsPoint) {
		System.out.println("*** "+dataModelElement.getType().name()+" - "+dataModelElement.getName());
		System.out.println("**** RETS:");
		for(String[] ret:rets){
			String aa="";
			for(int a=0;a<ret.length;a++){
				if(a>0)
					aa+=",";
				aa+=ret[a];
			}
			System.out.println("***** "+aa);
		}
		System.out.println("**** DETS:");
		for(int a=0;a<dets.length;a++){
			System.out.println("***** "+dets[a]);
		}
		System.out.println("*** Valor de pontos por função: "+totalFunctionsPoint);
		System.out.println("*** FIM-"+dataModelElement.getName());
	}

	@Override
	public void renderNoUsedField(Field field) {
		System.out.println("Campo removido = "+field.getParent().getName()+"/"+field.getName());
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSatisfactionPercentForFunctionPoint(
			FunctionPointSystem functionPointSystem, Double percent) {
		// TODO Auto-generated method stub
		
	}

}
