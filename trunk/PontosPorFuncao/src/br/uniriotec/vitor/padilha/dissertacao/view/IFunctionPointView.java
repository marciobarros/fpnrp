package br.uniriotec.vitor.padilha.dissertacao.view;

import java.util.List;

import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.dataModel.Field;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.TransactionModel;

public interface IFunctionPointView {

	public void renderTransactionModelValue(TransactionModel transactionModel, int totalTransations, int totalFunctionsPoint);
	
	public void renderTransactionValue(Transaction transaction, String[] ftrs, String[] dets, int totalFunctionsPoint);
	
	public void renderDataModelValue(DataModel dataModel, int totalDataModelElement, int totalFunctionsPoint);
	
	public void renderDataModelElementValue(DataModelElement dataModelElement, List<String[]> rets, String[] dets, int totalFunctionsPoint);

	public void renderNoUsedField(Field field);
}
