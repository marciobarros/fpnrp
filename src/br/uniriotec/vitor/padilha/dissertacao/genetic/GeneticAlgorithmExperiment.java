package br.uniriotec.vitor.padilha.dissertacao.genetic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import jmetal.base.Operator;
import jmetal.base.Solution;
import jmetal.base.SolutionSet;
import jmetal.base.operator.crossover.SinglePointCrossover;
import jmetal.base.operator.mutation.BitFlipMutation;
import jmetal.base.operator.selection.BinaryTournament;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.GANotifier;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.gGA;
import unirio.experiments.monoobjective.execution.MonoExperiment;
import br.uniriotec.vitor.padilha.dissertacao.calc.FunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;

/**
 * Class that represents an experiment involving a genetic algorithm
 * 
 * @author marciobarros
 */
public class GeneticAlgorithmExperiment extends MonoExperiment<SoftwareSystem> implements GANotifier
{
	private double budgetPercentile;
	private boolean optimizedVersion;
	private FunctionPointsProblem problem;
	private PrintWriter iterationDetailsFile;
	private SoftwareSystem instance;
	private double currentSatisfaction;
	private int cycleNumber;
	
	/**
	 * Initializes the experiment indicating the available percentile of the total budget
	 */
	public GeneticAlgorithmExperiment(double budgetPercentile, boolean optimizedVersion)
	{
		this.budgetPercentile = budgetPercentile;
		this.optimizedVersion = optimizedVersion;
		this.cycleNumber = 0;
	}
	
	/**
	 * Rusn a cycle of the experiment
	 */
	@Override
	protected Solution runCycle(SoftwareSystem instance, int instanceNumber) throws Exception
	{		
		problem = new FunctionPointsProblem(instance, budgetPercentile, optimizedVersion);
		int transactionCount = problem.countTransactions();

		int populationSize = 4 * transactionCount;
		int maxEvaluations = 20 * 4 * transactionCount * transactionCount;
		
		Operator crossover = new SinglePointCrossover();
		crossover.setParameter("probability", 0.9);
		
		Operator mutation = new BitFlipMutation();
		mutation.setParameter("probability", 1.0 / transactionCount);

		Operator selection = new BinaryTournament();

		gGA algorithm = new gGA(problem);
		algorithm.setInputParameter("populationSize", populationSize);
		algorithm.setInputParameter("maxEvaluations", maxEvaluations);
		algorithm.addOperator("crossover", crossover);
		algorithm.addOperator("mutation", mutation);
		algorithm.addOperator("selection", selection);
		
		this.cycleNumber++;
		this.instance = instance;
		this.currentSatisfaction = Double.MAX_VALUE;

		this.iterationDetailsFile = new PrintWriter(new BufferedWriter(new FileWriter("iterationDetails.txt", true)));
		algorithm.execute(this);
		this.iterationDetailsFile.close();
		
		SolutionSet solutions = algorithm.execute();
		return solutions.get(0);
	}
	
	/**
	 * Gathers information about a solution
	 */
	@Override
	protected double[] getSolutionData(Solution solution)
	{
		double[] data = new double[2];
		data[0] = problem.calculateSolutionCost(solution);
		data[1] = solution.getObjective(0);
		return data;
	}

	/**
	 * Publishes information as the solution improves
	 */
	@Override
	public void newIteration(int iterationNumber, Solution solution)
	{
		double satisfaction = solution.getObjective(0);

		if (satisfaction < currentSatisfaction)
		{
			boolean[] solutionArray = problem.convertSolutionBooleanArray(solution);
			String sSolution = FunctionPointsCalculator.toString(solutionArray);

			double cost = problem.calculateSolutionCost(solution);
			String sType = optimizedVersion ? "OPT" : "CLS"; 
			this.iterationDetailsFile.println(sType + "\t" + instance.getName() + "\t" + budgetPercentile + "%\t" + cycleNumber + "\t" + iterationNumber + "\t" + cost + "\t" + satisfaction + "\t" + sSolution);
			
			currentSatisfaction = satisfaction;
		}
	}
}