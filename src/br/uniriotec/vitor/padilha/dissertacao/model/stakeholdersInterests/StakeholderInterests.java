package br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests;

import java.util.ArrayList;
import java.util.List;

import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

/**
 * 
 * @author marcio.barros
 */
public class StakeholderInterests
{
	private List<Stakeholder> stakeholders;
	private List<Interest> interests;

	public Iterable<Stakeholder> getStakeholders()
	{
		return stakeholders;
	}

	public Iterable<Interest> getInterests()
	{
		return interests;
	}

	public List<Interest> getInterests(TransactionFunction transaction)
	{
		List<Interest> interests = new ArrayList<Interest>();

		for (Interest interest : getInterests())
		{
			if (interest.getTransaction().getName().equals(transaction.getName()))
				interests.add(interest);
		}
		return interests;
	}

	public void validade(FunctionPointSystem functionPointSystem, boolean validate) throws Exception
	{
		if (interests != null && functionPointSystem.getTransactionModel() != null && functionPointSystem.getTransactionModel().getTransactionFunctions() != null)
		{
			boolean findTransaction = false;
			boolean findInterest = false;
			for (Interest interest : this.interests)
			{
				for (TransactionFunction transaction : functionPointSystem.getTransactionModel().getTransactionFunctions())
				{
					if (interest.getTransactionXML().equals(transaction.getName()))
					{
						interest.setTransaction(transaction);
						findTransaction = true;
					}
				}
				for (Stakeholder stakeholder : this.stakeholders)
				{
					if (stakeholder.getName().equals(interest.getStakeholderXML()))
					{
						interest.setStakeholder(stakeholder);
						findInterest = true;
					}
				}
				if (validate && (!findInterest || !findTransaction))
				{
					throw new Exception("Transação ou grau de interesse não encontrado!");
				}
			}
		}
	}
}