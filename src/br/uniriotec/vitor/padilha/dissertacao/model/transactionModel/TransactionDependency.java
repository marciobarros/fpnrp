package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that represents a dependency from a transaction to another transaction
 * 
 * @author Marcio
 */
public class TransactionDependency
{
	private @Getter String referencedTransactionFunctionName;
	private @Getter @Setter TransactionFunction referencedTransactionFunction;
	private @Getter Boolean canBeWeak;
	
	public TransactionDependency(String referencedTransactionFunctionName, boolean canbeWeak) 
	{
		this.referencedTransactionFunctionName = referencedTransactionFunctionName;
		this.referencedTransactionFunction = null;
		this.canBeWeak = canbeWeak;
	}
}