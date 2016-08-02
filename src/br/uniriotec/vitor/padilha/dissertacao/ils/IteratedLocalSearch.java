package br.uniriotec.vitor.padilha.dissertacao.ils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.uniriotec.vitor.padilha.dissertacao.calc.ClassicFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.calc.FunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.calc.OptimizedFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import jmetal.util.PseudoRandom;
import lombok.Getter;

/**
 * Abstract class that represents a search algorithm
 * 
 * @author Marcio
 */
public class IteratedLocalSearch 
{
	/**
	 * Number of transactions changed during perturbation
	 */
	private static final int PERTURBATION_AMOUNT = 10;

	/**
	 * File where details of the search process will be printed
	 */
	private PrintStream detailsFile;
	
	/**
	 * Prefix to be used while presenting detail informations
	 */
	private String prefixDetails;

	/**
	 * Set of requirements to be optimized
	 */
	private SoftwareSystem project;

	/**
	 * Calculator for the software system
	 */
	private FunctionPointsCalculator calculator;
	
	/**
	 * Available budget for optimization
	 */
	private double availableBudget;

	/**
	 * Number of fitness evaluations available in the budget
	 */
	private @Getter int maxEvaluations;

	/**
	 * Number of fitness evaluations executed
	 */
	private @Getter int evaluationsConsumed;

	/**
	 * Number of iterations to best solution
	 */
	private @Getter int iterationBestFound;

	/**
	 * Profit/loss ratio for each transaction
	 */
	private Map<Integer, Integer> profitLossRatios;

	/**
	 * Order under which requirements will be accessed
	 */
	private int[] selectionOrder;

	/**
	 * Initializes the search process
	 */
	public IteratedLocalSearch(PrintStream detailsFile, String prefixDetails, SoftwareSystem project, double budgetPercentile, boolean optimizedVersion, int maxEvaluations)
	{
		this.project = project;
		this.calculator = optimizedVersion ? new OptimizedFunctionPointsCalculator(project) : new ClassicFunctionPointsCalculator(project);
		this.availableBudget = calculator.calculateCost(calculator.allTransactions()) * budgetPercentile / 100.0;
		
		this.maxEvaluations = maxEvaluations;
		this.detailsFile = detailsFile;
		this.prefixDetails = prefixDetails;
		this.evaluationsConsumed = 0;
		this.iterationBestFound = 0;

		calculateProfitLossRatios();
		createRandomSelectionOrder();
	}

	/**
	 * Calculates the profit/loss ratio for each transaction
	 */
	private void calculateProfitLossRatios()
	{
		int transactionCount = project.getTransactionModel().countTransactionFunctions();
		boolean[] solution = new boolean[transactionCount];
		Arrays.fill(solution, false);

		this.profitLossRatios = new HashMap<Integer, Integer>(transactionCount);

		for (int transaction = 0; transaction < transactionCount; transaction++)
		{
			solution[transaction] = true;
			double profit = calculator.calculateSatisfaction(solution);
			int cost = calculator.calculateCost(solution);
			solution[transaction] = false;
			profitLossRatios.put(transaction, (int) ((profit / cost) * 1000));
		}
	}
	
	/**
	 * Creates a random order by requirement selection
	 */
	private void createRandomSelectionOrder()
	{
		int transactionCount = project.getTransactionModel().countTransactionFunctions();
		int[] temporaryOrder = new int[transactionCount];

		for (int i = 0; i < transactionCount; i++)
			temporaryOrder[i] = i;

		this.selectionOrder = new int[transactionCount];

		for (int i = 0; i < transactionCount; i++)
		{
			double random = PseudoRandom.randDouble();
			int index = (int) (random * (transactionCount - i));
			this.selectionOrder[i] = temporaryOrder[index];

			for (int j = index; j < transactionCount - 1; j++)
				temporaryOrder[j] = temporaryOrder[j + 1];
		}
	}

	/**
	 * Generates a unbounded, greedy solution
	 */
	private boolean[] generateGreedySolution()
	{
		int transactionCount = project.getTransactionModel().countTransactionFunctions();
		boolean[] solution = new boolean[transactionCount];
		Arrays.fill(solution, false);
		
		List<Integer> transactions = new ArrayList<Integer>(profitLossRatios.keySet());

		for (int i = 0; i < transactionCount; i++)
		{
			int selected = getWeightedRandom(transactions);
			selected = transactions.remove(selected);
			solution[selected] = true;

			double cost = calculator.calculateCost(solution);
			
			if (cost > availableBudget)
			{
				solution[selected] = false;
				return solution;
			}
		}

		return solution;
	}

	/**
	 * Randomly selects a transaction, weighting the chances for their weights
	 */
	private int getWeightedRandom(List<Integer> transactions)
	{
		int[] weights = getWeightsFor(transactions);
		int[] cumulative = computeCumulativeWeights(weights);
		int totalWeight = cumulative[cumulative.length-1]; 
				
		int rand = PseudoRandom.randInt(0, totalWeight-1);
		int pos = Arrays.binarySearch(cumulative, rand);
		
		if (pos < 0)
			pos = Math.abs(pos) - 1;

		return pos;
	}

	/**
	 * Returns the weights for a list of transactions
	 */
	private int[] getWeightsFor(List<Integer> transactions)
	{
		int[] weights = new int[transactions.size()];
		int index = 0;

		for (Integer transaction : transactions)
		{
			weights[index] = profitLossRatios.get(transaction);
			index++;
		}
		
		return weights;
	}

	/**
	 * Computes a list of cumulative weights for the customers
	 */
	private int[] computeCumulativeWeights(int[] weights)
	{
		int[] lookup = new int[weights.length];
		int total = 0;

		for (int i = 0; i < weights.length; i++)
		{
			total += weights[i];
			lookup[i] = total;
		}

		return lookup;
	}

	/**
	 * Runs a neighborhood visit starting from a given solution
	 */
	private NeighborhoodVisitorResult visitNeighbors(boolean[] solution, double bestFitness)
	{
		double startingFitness = evaluate(solution, bestFitness);

		if (evaluationsConsumed > maxEvaluations)
			return new NeighborhoodVisitorResult(NeighborhoodVisitorStatus.SEARCH_EXHAUSTED);

		int transactionCount = project.getTransactionModel().countTransactionFunctions();

		for (int i = 0; i < transactionCount; i++)
		{
			int transactionI = selectionOrder[i];
			
			solution[transactionI] = !solution[transactionI];
			double neighborFitness = evaluate(solution, bestFitness);

			if (evaluationsConsumed > maxEvaluations)
				return new NeighborhoodVisitorResult(NeighborhoodVisitorStatus.SEARCH_EXHAUSTED);

			if (neighborFitness > startingFitness)
				return new NeighborhoodVisitorResult(NeighborhoodVisitorStatus.FOUND_BETTER_NEIGHBOR, neighborFitness);
			
			solution[transactionI] = !solution[transactionI];
		}

		return new NeighborhoodVisitorResult(NeighborhoodVisitorStatus.NO_BETTER_NEIGHBOR);
	}

	/**
	 * Performs the local search starting from a given solution
	 */
	private boolean[] localSearch(boolean[] solution, double bestFitness)
	{
		NeighborhoodVisitorResult result;

		boolean[] bestLocalSolution = Arrays.copyOf(solution, solution.length);
		double bestLocalFitness = evaluate(bestLocalSolution, bestFitness);

		do
		{
			result = visitNeighbors(bestLocalSolution, bestFitness);

			if (result.getStatus() == NeighborhoodVisitorStatus.FOUND_BETTER_NEIGHBOR && result.getNeighborFitness() > bestLocalFitness)
			{
				bestLocalFitness = result.getNeighborFitness();
				this.iterationBestFound = evaluationsConsumed;
			}

		} while (result.getStatus() == NeighborhoodVisitorStatus.FOUND_BETTER_NEIGHBOR);

		return bestLocalSolution;
	}

	/**
	 * Applies the perturbation operator upon a solution
	 */
	private boolean[] applyPerturbation(boolean[] solution)
	{
		int transactionCount = solution.length;
		boolean[] perturbedSolution = Arrays.copyOf(solution, transactionCount);

		for (int i = 0; i < PERTURBATION_AMOUNT; i++)
		{
			int transaction = PseudoRandom.randInt(0, transactionCount-1);
			perturbedSolution[transaction] = !perturbedSolution[transaction];
		}

		return perturbedSolution;
	}

	/**
	 * Main loop of the algorithm
	 */
	public boolean[] execute() throws Exception
	{
		boolean[] bestSolution = generateGreedySolution();
		double bestFitness = evaluate(bestSolution, 0.0);

		boolean[] solution = localSearch(bestSolution, bestFitness);
		double fitness = evaluate(solution, bestFitness);
		
		if (fitness > bestFitness)
		{
			bestSolution = solution;
			bestFitness = fitness;
		}
		
		while (evaluationsConsumed < maxEvaluations)
		{
			boolean[] perturbedSolution = applyPerturbation(bestSolution);
			solution = localSearch(perturbedSolution, bestFitness);
			fitness = evaluate(solution, bestFitness);
			
			if (fitness > bestFitness)
			{
				bestSolution = solution;
				bestFitness = fitness;
			}
		}

		return bestSolution;
	}

	/**
	 * Evaluates the fitness of a solution, saving detail information
	 */
	protected double evaluate(boolean[] solution, double bestFitness)
	{
		++evaluationsConsumed;
		double fitness = calculateSolutionFitness(solution);
		
		if (fitness > bestFitness && detailsFile != null)
			detailsFile.println(prefixDetails + "," + evaluationsConsumed + "," + fitness);
		
		return fitness;
	}

	/**
	 * Calculates the cost of a solution
	 */
	public double calculateSolutionFitness(boolean[] solution)
	{
		int cost = calculator.calculateCost(solution);

		if (cost <= availableBudget)
			return calculator.calculateSatisfactionPercentile(solution);

		return availableBudget - cost;
	}
}

/**
 * Set of potential results from visiting neighbors
 */
enum NeighborhoodVisitorStatus
{
	FOUND_BETTER_NEIGHBOR, NO_BETTER_NEIGHBOR, SEARCH_EXHAUSTED
}

/**
 * Class that represents the results of the local search phase
 */
class NeighborhoodVisitorResult
{
	/**
	 * Status in the end of the local search
	 */
	private NeighborhoodVisitorStatus status;

	/**
	 * Fitness of the best neighbor, in case one has been found
	 */
	private double neighborFitness;

	/**
	 * Initializes a successful local search status
	 */
	public NeighborhoodVisitorResult(NeighborhoodVisitorStatus status, double fitness)
	{
		this.status = status;
		this.neighborFitness = fitness;
	}

	/**
	 * Initializes an unsuccessful local search
	 */
	public NeighborhoodVisitorResult(NeighborhoodVisitorStatus status)
	{
		this.status = status;
		this.neighborFitness = 0.0;
	}

	/**
	 * Returns the status of the local search
	 */
	public NeighborhoodVisitorStatus getStatus()
	{
		return status;
	}

	/**
	 * Return the fitness of the best neighbor found, if any
	 */
	public double getNeighborFitness()
	{
		return neighborFitness;
	}
}