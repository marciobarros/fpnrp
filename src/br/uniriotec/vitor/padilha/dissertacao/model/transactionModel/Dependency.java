package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import lombok.Data;

/**
 * Class that represents a dependency from a transaction to another transaction
 * 
 * @author Marcio
 */
public @Data class Dependency
{
	private Transaction transactionDependency;
	private String ref;
	private Boolean canBeWeak;

//	public boolean validate() throws Exception
//	{
//		if (this.getRef() == null || this.getRef().equals(""))
//			throw new Exception("Referência obrigatória");
//		
//		if (getCanBeWeak() == null)
//			this.setCanBeWeak(false);
//		
//		if (getTransactionDependency() == null)
//			throw new Exception("Elemento:'" + getRef() + "' não encontrado");
//		
//		return true;
//	}

//	public void charge()
//	{
//		if (getParent().getParent().getTransactions() != null)
//		{
//			for (Transaction transaction : getParent().getParent().getTransactions())
//			{
//				if (transaction.getName().equals(getRef()))
//				{
//					setTransactionDependency(transaction);
//				}
//			}
//		}
//	}
}