package br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Class that represents an instance in an experiment
 * 
 * @author Marcio Barros
 */
public class MonoExperimentInstance
{
	private List<MonoExperimentCycle> cycles;
	
	/**
	 * Initializes the instance
	 */
	public MonoExperimentInstance()
	{
		this.cycles = new ArrayList<MonoExperimentCycle>();
	}
	
	/**
	 * Returns the number of cycles in the instance
	 */
	public int countCycles()
	{
		return cycles.size();
	}
	
	/**
	 * Returns a cycle for the instance
	 */
	public MonoExperimentCycle getCycleIndex(int index)
	{
		return cycles.get(index);
	}
	
	/**
	 * Adds a cycle in the instance
	 */
	public void addCycle(MonoExperimentCycle item)
	{
		cycles.add(item);
	}
	
	/**
	 * Removes a cycle from the instance
	 */
	public void removeCycle(int index)
	{
		cycles.remove(index);
	}
	
	/**
	 * Returns the execution times for the instance
	 */
	public double[] getExecutionTimes()
	{
		double[] results = new double[cycles.size()];
		
		for (int i = 0; i < cycles.size(); i++)
			results[i] = getCycleIndex(i).getExecutionTime();
		
		return results;
	}
	
	/**
	 * Returns the fitness values for the instance
	 */
	public double[] getObjectives()
	{
		double[] results = new double[cycles.size()];
		
		for (int i = 0; i < cycles.size(); i++)
			results[i] = getCycleIndex(i).getObjective();
		
		return results;
	}
	
	/**
	 * Returns the locations for the instance
	 */
	public double[] getLocation()
	{
		double[] results = new double[cycles.size()];
		
		for (int i = 0; i < cycles.size(); i++)
			results[i] = getCycleIndex(i).getLocation();
		
		return results;
	}
	
	/**
	 * Returns an additional data for the instance
	 */
	public double[] getAdditionalData(int index)
	{
		double[] results = new double[cycles.size()];
		
		for (int i = 0; i < cycles.size(); i++)
			results[i] = getCycleIndex(i).getAdditionalData(index);
		
		return results;
	}
}