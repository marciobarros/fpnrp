package br.uniriotec.vitor.padilha.dissertacao.genetic;

import jmetal.base.Problem;
import jmetal.base.Solution;
import jmetal.base.solutionType.BinarySolutionType;
import jmetal.base.variable.Binary;
import jmetal.util.JMException;
import br.uniriotec.vitor.padilha.dissertacao.calc.FunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;

/**
 * Class that represents the problem under optimization
 * 
 * @author marciobarros
 */
public class FunctionPointsProblem extends Problem
{
	private FunctionPointsCalculator calculator;
	private double availableBudget;
	private double totalSatisfaction;
	private int evaluations;

	/**
	 * Initializes the problem
	 */
	public FunctionPointsProblem(SoftwareSystem system, double budgetPercentile) throws ClassNotFoundException
	{
		this.calculator = new FunctionPointsCalculator(system);
		availableBudget = calculator.getTotalCost() * budgetPercentile / 100.0;
		totalSatisfaction = calculator.getTotalSatisfaction();
		
		this.evaluations = 0;
		numberOfObjectives_ = 1;
		numberOfVariables_ = 1;
		
		solutionType_ = new BinarySolutionType(this);
		length_ = new int[numberOfVariables_];
		length_[0] = calculator.getTransactionCount();
	}
	
	/**
	 * Calculates the fitness for a solution
	 */
	@Override
	public void evaluate(Solution solution) throws JMException
	{
		boolean[] transactions = convertSolutionBooleanArray(solution);
		int cost = calculator.calculateCost(transactions);
		double fitness = 0;

		if (cost <= availableBudget)
			fitness = -100.0 * calculator.calculateSatisfaction(transactions) / totalSatisfaction;
		else
			fitness = cost - availableBudget;
		
		solution.setObjective(0, fitness);
		solution.setLocation(evaluations);
		evaluations++;
	}

	/**
	 * Counts the transaction in the problem
	 */
	public int countTransactions()
	{
		return calculator.getTransactionCount();
	}

	/**
	 * Calculates the cost of a solution
	 */
	public int calculateSolutionCost(Solution solution)
	{
		boolean[] transactions = convertSolutionBooleanArray(solution);
		return calculator.calculateCost(transactions);
	}

	/**
	 * Converts a solution to a boolean array indicating the presence of transactions
	 */
	private boolean[] convertSolutionBooleanArray(Solution solution)
	{
		Binary portfolio = (Binary) solution.getDecisionVariables()[0];
		boolean[] transactions = new boolean[calculator.getTransactionCount()];
		
		for (int i = 0; i < transactions.length; i++)
			transactions[i] = portfolio.bits_.get(i);
		
		return transactions;
	}
}