package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that represents a transaction
 * 
 * @author Marcio
 */
public class Transaction
{
	private @Getter @Setter String name;
	private @Getter @Setter boolean errorMsg;
	private @Getter @Setter TransactionType type;
	private List<Dependency> dependencies;
	private List<FileReference> fileReferences;
	private @Getter @Setter int extraDET;
	private @Getter @Setter int releaseImplementation;

	/**
	 * Initializes a transaction
	 */
	public Transaction()
	{
		this.name = "";
		this.errorMsg = false;
		this.type = null;
		this.dependencies = new ArrayList<Dependency>();
		this.fileReferences = new ArrayList<FileReference>();
		this.extraDET = 0;
		this.releaseImplementation = 0;
	}
	
	/**
	 * Returns a count of thhe number of dependencies in the transaction
	 */
	public int countDependencies()
	{
		return dependencies.size();
	}
	
	/**
	 * Adds a dependency to the transaction
	 */
	public void addDependency(Dependency dependency)
	{
		dependencies.add(dependency);
	}
	
	/**
	 * Returns the dependencies of the transaction
	 */
	public Iterable<Dependency> getDependencies()
	{
		return dependencies;
	}

	/**
	 * Counts the number of files referenced by the transaction
	 */
	public int countFileReferences()
	{
		return fileReferences.size();
	}

	/**
	 * Returns a file reference, given its index
	 */
	public FileReference getFileReferenceIndex(int index) 
	{
		return fileReferences.get(index);
	}
	
	/**
	 * Adds a reference to a file in the transaction
	 */
	public void addFileReference(FileReference reference)
	{
		fileReferences.add(reference);
	}
	
	/**
	 * Removes a reference to a file in the transaction
	 */
	public void removeFileReference(int index)
	{
		fileReferences.remove(index);
	}
	
	/**
	 * Returns all files referenced by the transaction
	 */
	public Iterable<FileReference> getFileReferences()
	{
		return fileReferences;
	}

	/**
	 * 
	 */
	public void eliminateDependendyTransactions(Transaction[] transactions)
	{
//		for (int i = 0; i < transactions.length; i++)
//		{
//			Transaction transaction = transactions[i];
//			if (transaction != null && transaction.getDependencies() != null)
//			{
//				for (Dependency dependency : transaction.getDependencies())
//				{
//					if (dependency.getTransactionDependency().equals(this))
//					{
//						this.getParent().getTransactions().remove(transaction);
//						transactions[i] = null;
//						transaction.eliminateDependendyTransactions(transactions);
//					}
//				}
//			}
//		}
	}

//	public boolean validate() throws Exception
//	{
//		if (getName() == null || getName().equals(""))
//		{
//			throw new Exception("Nome obrigatório!");
//		}
//
//		if (getType() == null || getType().equals("") || (!getType().equals(TransactionType.EI) && !getType().equals(TransactionType.EO) && !getType().equals(TransactionType.EQ)))
//		{
//			throw new Exception("Tipo de transação inválida!");
//		}
//
//		if (getFileReferences() != null)
//			for (FileReference ftr : getFileReferences())
//			{
//				if (!ftr.validate())
//				{
//					return false;
//				}
//			}
//		if (getDependencies() != null)
//			for (Dependency dependency : getDependencies())
//			{
//				if (!dependency.validate())
//				{
//					return false;
//				}
//			}
//		return true;
//	}

	public String doDot(boolean present)
	{
		String retorno = "";

		if (!present)
			retorno += getName() + "[color=red fontcolor=red]\n";
		
		if (this.getReleaseImplementation() > 0)
		{
			switch (this.getReleaseImplementation())
			{
			case 1:
				retorno += getName() + "[color=blue fontcolor=blue]\n";
				break;
			case 2:
				retorno += getName() + "[color=yellow fontcolor=yellow]\n";
				break;
			case 3:
				retorno += getName() + "[color=green fontcolor=green]\n";
				break;
			case 4:
				retorno += getName() + "[color=orange fontcolor=orange]\n";
				break;
			case 5:
				retorno += getName() + "[color=purple fontcolor=purple]\n";
				break;
			case 6:
				retorno += getName() + "[color=gray fontcolor=gray]\n";
				break;
			}
		}
		
		if (getDependencies() != null)
		{
			for (Dependency dependency : getDependencies())
			{
				retorno += getName() + "->" + dependency.getRef();
				retorno += "[";
				if (dependency.getCanBeWeak())
					retorno += "style=dotted ";
				retorno += ((present) ? "" : "color=red");
				retorno += "]";
				retorno += "\n";
			}
		}
		return retorno;
	}

//	public void charge()
//	{
//		if (getFileReferences() != null)
//			for (FileReference ftr : getFileReferences())
//			{
//				ftr.charge();
//			}
//
//		if (getDependencies() != null)
//			for (Dependency dependency : getDependencies())
//			{
//				dependency.charge();
//			}
//	}
}