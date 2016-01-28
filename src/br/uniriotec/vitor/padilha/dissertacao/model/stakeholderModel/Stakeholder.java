package br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Class that represents a stakeholder for a system
 * 
 * @author marcio.barros
 */
public class Stakeholder 
{
	private @Getter String name;
	private @Getter int weight;
	private List<Interest> interests;

	/**
	 * Initializes a stakeholder
	 */
	public Stakeholder(String name, int weight)
	{
		this.name = name;
		this.weight = weight;
		this.interests = new ArrayList<Interest>();
	}
	
	/**
	 * Count the number of interests
	 */
	public int countInterests()
	{
		return interests.size();
	}

	/**
	 * Returns an interest, given its index
	 */
	public Interest getInterestIndex(int index)
	{
		return interests.get(index);
	}
	
	/**
	 * Adds an interest to the stakeholder
	 */
	public void addInterest(Interest interest)
	{
		interests.add(interest);
	}

	/**
	 * Returns the interests of the stakeholder
	 */
	public Iterable<Interest> getInterests()
	{
		return interests;
	}
}