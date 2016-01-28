package br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel;

import java.util.ArrayList;
import java.util.List;

import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

/**
 * Class that represents a stakeholder model for a system
 * 
 * @author marcio.barros
 */
public class StakeholderModel
{
	private List<Stakeholder> stakeholders;
	
	/**
	 * Initializes the stakeholder model
	 */
	public StakeholderModel()
	{
		this.stakeholders = new ArrayList<Stakeholder>();
	}
	
	/**
	 * Count the number of stakeholders in the model
	 */
	public int countStakeholders()
	{
		return stakeholders.size();
	}

	/**
	 * Returns a stakeholder, given its index
	 */
	public Stakeholder getStakeholderIndex(int index)
	{
		return stakeholders.get(index);
	}

	/**
	 * Returns a stakeholder, given its name
	 */
	public Stakeholder getStakeholderName(String name)
	{
		for (Stakeholder stakeholder : stakeholders)
			if (stakeholder.getName().compareToIgnoreCase(name) == 0)
				return stakeholder;
		
		return null;
	}
	
	/**
	 * Adds a stakeholder to the model
	 */
	public void addStakeholder(Stakeholder stakeholder)
	{
		stakeholders.add(stakeholder);
	}

	/**
	 * Returns the stakeholders for the system
	 */
	public Iterable<Stakeholder> getStakeholders()
	{
		return stakeholders;
	}

	/**
	 * List all interests for a transaction function
	 */
	public List<Interest> getInterests(TransactionFunction transaction)
	{
		List<Interest> interests = new ArrayList<Interest>();

		for (Stakeholder stakeholder : stakeholders)
		{
			for (Interest interest : stakeholder.getInterests())
			{
				if (interest.getTransaction() == transaction)
					interests.add(interest);
			}
		}

		return interests;
	}
}