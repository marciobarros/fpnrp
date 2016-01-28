package br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel;

import lombok.Data;
import lombok.Getter;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

/**
 * Class that represents the interest of a stakeholder in a transaction
 * 
 * @author marcio.barros
 */
public @Data class Interest 
{
	private @Getter TransactionFunction transaction;
	private @Getter int value;
	
	/**
	 * Initializes a stakeholder's interest
	 */
	public Interest(TransactionFunction transaction, int value)
	{
		this.transaction = transaction;
		this.value = value;
	}
}