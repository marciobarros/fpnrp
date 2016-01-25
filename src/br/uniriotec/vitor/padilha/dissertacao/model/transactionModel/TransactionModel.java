package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.ArrayList;
import java.util.List;

public class TransactionModel
{
	private List<Transaction> transactions;

	public Iterable<Transaction> getTransactions()
	{
		return transactions;
	}

	public boolean validate() throws Exception
	{
		for (Transaction transaction : getTransactions())
		{
			if (!transaction.validate())
			{
				return false;
			}
		}
		return true;
	}

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
					for (FTR ftr : transaction.getFtrList())
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

	public void charge()
	{
		for (Transaction transaction : getTransactions())
			transaction.charge();
	}
}