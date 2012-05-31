package br.uniriotec.vitor.padilha.dissertacao.view;

import java.util.List;

import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.TransactionModel;

public class SystemOutFunctionPointView extends GenericFunctionPointView{

	@Override
	public void renderTransactionModelValue(TransactionModel transactionModel,
			int totalTransations, int totalFunctionsPoint) {
		System.out.println("**** Total de pontos por fun��o n�o ajustado para transa��es: "+totalFunctionsPoint+" para "+totalTransations+" transa��es");

		
	}

	@Override
	public void renderTransactionValue(Transaction transaction, String[] ftrs,
			String[] dets, int totalFunctionsPoint) {
		System.out.println("*** "+transaction.getType().name()+" - "+transaction.getName());
		System.out.println("**** FTRS:");
		for(int a=0;a<ftrs.length;a++){
			System.out.println("***** "+ftrs[a]);
		}
		System.out.println("**** DETS:");
		for(int a=0;a<dets.length;a++){
			System.out.println("***** "+dets[a]);
		}
		System.out.println("*** Valor de pontos por fun��o: "+totalFunctionsPoint);
		System.out.println("*** FIM-"+transaction.getName());
		
	}

	@Override
	public void renderDataModelValue(DataModel dataModel,
			int totalDataModelElement, int totalFunctionsPoint) {
		System.out.println("**** Total de pontos por fun��o n�o ajustado para fun��o de dados: "+totalFunctionsPoint+" para "+totalDataModelElement+" arquivos");
	}

	@Override
	public void renderDataModelElementValue(DataModelElement dataModelElement,
			List<String[]> rets, String[] dets, int totalFunctionsPoint) {
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
		System.out.println("*** Valor de pontos por fun��o: "+totalFunctionsPoint);
		System.out.println("*** FIM-"+dataModelElement.getName());
	}

	@Override
	public void renderNoUsedField(Field field) {
		System.out.println("Campo removido = "+field.getParent().getName()+"/"+field.getName());
		
	}

}
