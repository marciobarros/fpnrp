package br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Class that represents the results for a mono-objective experiment
 * 
 * @author Marcio Barros
 */
public class MonoExperimentResult
{
	private List<MonoExperimentInstance> instances;
	private @Getter String name;
	
	/**
	 * Initializes the experimental result
	 */
	public MonoExperimentResult(String name)
	{
		this.name = name;
		this.instances = new ArrayList<MonoExperimentInstance>();
	}
	
	/**
	 * Returns the number of instances in the result
	 */
	public int countInstances()
	{
		return instances.size();
	}
	
	/**
	 * Returns an instance in the result
	 */
	public MonoExperimentInstance getInstanceIndex(int index)
	{
		return instances.get(index);
	}
	
	/**
	 * Adds an instance to the result
	 */
	public void addInstance(MonoExperimentInstance item)
	{
		instances.add(item);
	}
	
	/**
	 * Removes an instance from the result
	 */
	public void removeInstance(int index)
	{
		instances.remove(index);
	}
}