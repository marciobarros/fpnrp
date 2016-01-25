package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.uniriotec.vitor.padilha.dissertacao.model.constants.TransactionType;

public class Transaction
{
	private @Getter @Setter String name;
	private @Getter @Setter boolean errorMsg;
	private @Getter @Setter TransactionType type;
	private List<Dependency> dependencies;
	private List<FTR> ftrList;
	private @Getter @Setter int extraDET;
	private @Getter @Setter int releaseImplementation;

	public Iterable<Dependency> getDependencies()
	{
		return dependencies;
	}

	public Iterable<FTR> getFtrList()
	{
		return ftrList;
	}

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

	public boolean validate() throws Exception
	{
		if (getName() == null || getName().equals(""))
		{
			throw new Exception("Nome obrigatório!");
		}

		if (getType() == null || getType().equals("") || (!getType().equals(TransactionType.EI) && !getType().equals(TransactionType.EO) && !getType().equals(TransactionType.EQ)))
		{
			throw new Exception("Tipo de transação inválida!");
		}

		if (getFtrList() != null)
			for (FTR ftr : getFtrList())
			{
				if (!ftr.validate())
				{
					return false;
				}
			}
		if (getDependencies() != null)
			for (Dependency dependency : getDependencies())
			{
				if (!dependency.validate())
				{
					return false;
				}
			}
		return true;
	}

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
			default:
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

	public void charge()
	{
		if (getFtrList() != null)
			for (FTR ftr : getFtrList())
			{
				ftr.charge();
			}

		if (getDependencies() != null)
			for (Dependency dependency : getDependencies())
			{
				dependency.charge();
			}
	}
}