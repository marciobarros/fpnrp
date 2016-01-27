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
	 * List of transactions contained in the model
	 */
	private List<Transaction> transactions;

	/**
	 * Initializes the transaction model
	 */
	public TransactionModel()
	{
		this.transactions = new ArrayList<Transaction>();
	}
	
	/**
	 * Counts the number of transactions in the model
	 */
	public int countTransactions()
	{
		return transactions.size();
	}

	/**
	 * Returns a transaction, given its index
	 */
	public Transaction getTransactionIndex(int index) 
	{
		return transactions.get(index);
	}

	/**
	 * Returns a transaction, given its name
	 */
	public Transaction getTransactionName(String name) 
	{
		for (Transaction transaction : transactions)
			if (transaction.getName().compareToIgnoreCase(name) == 0)
				return transaction;
		
		return null;
	}
	
	/**
	 * Adds a transaction to the model
	 */
	public void addTransaction(Transaction transaction)
	{
		this.transactions.add(transaction);
	}
	
	/**
	 * Removes a transaction from the model
	 */
	public void removeTransaction(int index)
	{
		this.transactions.remove(index);
	}
	
	/**
	 * Returns all transactions in the model
	 */
	public Iterable<Transaction> getTransactions()
	{
		return transactions;
	}

//	public boolean validate() throws Exception
//	{
//		for (Transaction transaction : getTransactions())
//		{
//			if (!transaction.validate())
//			{
//				return false;
//			}
//		}
//		return true;
//	}

	public String doDot(List<Transaction> baseTransaction, boolean showDataModel)
	{
		List<String> baseNames = new ArrayList<String>();
		for (Transaction transaction : baseTransaction)
		{
			baseNames.add(transaction.getName());
		}
		String retorno = "";
		if (getTransactions() != null)
		{
			for (Transaction transaction : this.getTransactions())
			{
				boolean present = baseNames.contains(transaction.getName());
				String dotTransaction = transaction.doDot(present);
				if (!dotTransaction.equals(""))
					retorno += dotTransaction;
				if (showDataModel)
				{
					for (FileReference ftr : transaction.getFileReferences())
					{
						retorno += transaction.getName() + "->" + ftr.getName() + "[arrowType=none";
						if (!present)
							retorno += " color=red";
						retorno += "]\n";
					}
				}
			}
		}
		retorno += "";
		return retorno;
	}

//	public void charge()
//	{
//		for (Transaction transaction : getTransactions())
//			transaction.charge();
//	}
}