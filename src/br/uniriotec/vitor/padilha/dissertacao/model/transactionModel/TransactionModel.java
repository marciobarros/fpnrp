package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a transaction model for a system
 * 
 * @author Marcio
 */
public class TransactionModel
{
	/**
	 * List of transaction functions contained in the model
	 */
	private List<TransactionFunction> transactions;

	/**
	 * Initializes the transaction model
	 */
	public TransactionModel()
	{
		this.transactions = new ArrayList<TransactionFunction>();
	}
	
	/**
	 * Counts the number of transaction functions in the model
	 */
	public int countTransactionFunctions()
	{
		return transactions.size();
	}

	/**
	 * Returns a transaction function, given its index
	 */
	public TransactionFunction getTransactionFunctionIndex(int index) 
	{
		return transactions.get(index);
	}

	/**
	 * Returns a transaction function, given its name
	 */
	public TransactionFunction getTransactionFunctionName(String name) 
	{
		for (TransactionFunction transaction : transactions)
			if (transaction.getName().compareToIgnoreCase(name) == 0)
				return transaction;
		
		return null;
	}
	
	/**
	 * Adds a transaction function to the model
	 */
	public void addTransactionFunction(TransactionFunction transaction)
	{
		this.transactions.add(transaction);
	}
	
	/**
	 * Removes a transaction function from the model
	 */
	public void removeTransactionFunction(int index)
	{
		this.transactions.remove(index);
	}
	
	/**
	 * Returns all transactions functions in the model
	 */
	public Iterable<TransactionFunction> getTransactionFunctions()
	{
		return transactions;
	}
}