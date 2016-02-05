package br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that represents a cycle for an instance in the experiment
 * 
 * @author Marcio Barros
 */
public class MonoExperimentCycle
{
	private @Getter @Setter double executionTime;
	private @Getter @Setter double objective;
	private @Getter @Setter long location;
	private @Getter @Setter String solution;
	private double[] additionalData;
	
	/**
	 * Initializes the cycle
	 */
	public MonoExperimentCycle(int additionalDataCount)
	{
		this.executionTime = 0.0;
		this.location = 0;
		this.objective = 0.0;
		this.solution = "";
		this.additionalData = new double[additionalDataCount];
	}
	
	/**
	 * Sets an additional data information
	 */
	public void setAdditionalData(int index, double data)
	{
		this.additionalData[index] = data;
	}
	
	/**
	 * Gets an additional data information
	 */
	public double getAdditionalData(int index)
	{
		return this.additionalData[index];
	}
}