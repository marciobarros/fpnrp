package br.uniriotec.vitor.padilha.dissertacao.transactionModel;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import br.uniriotec.vitor.padilha.dissertacao.ElementValidator;
import br.uniriotec.vitor.padilha.dissertacao.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElementWithParent;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

@XmlType(name="transaction-model")
public class TransactionModel extends XmlFunctionPointElementWithParent<FunctionPointSystem> implements ElementValidator{

	
	private List<Transaction> transactions;

	@XmlElement(required=false,name="transaction")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public boolean validate() throws ElementException {
		for(Transaction transaction:getTransactions()){
			if(!transaction.validate()){
				return false;
			}
		}
		return true;
	}
	public String doDot() {
		String retorno = "digraph teste {\n";
		if(getTransactions()!=null) {
			for(Transaction transaction:getTransactions()){
				String dotTransaction = transaction.doDot();
				if(!dotTransaction.equals(""))
					retorno+=dotTransaction;
			}
		}
		retorno += "}";
		return retorno;
		
	}
}
