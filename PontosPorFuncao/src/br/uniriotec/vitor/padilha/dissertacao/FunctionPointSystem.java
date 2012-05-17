package br.uniriotec.vitor.padilha.dissertacao;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.uniriotec.vitor.padilha.dissertacao.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;
import br.uniriotec.vitor.padilha.dissertacao.transactionModel.TransactionModel;

@XmlRootElement(name="system")
public class FunctionPointSystem extends XmlFunctionPointElement implements ElementValidator{

	private DataModel dataModel;
	
	private TransactionModel transactionModel;
	
	@XmlElement(required=true,name="data-model")
	public DataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	@XmlElement(required=true,name="transaction-model")
	public TransactionModel getTransactionModel() {
		return transactionModel;
	}

	public void setTransactionModel(TransactionModel transactionModel) {
		this.transactionModel = transactionModel;
	}

	@Override
	public boolean validate() throws ElementException {
		if(this.getDataModel().validate() && this.getTransactionModel().validate())
			return true;
		return false;
	}

	
}
