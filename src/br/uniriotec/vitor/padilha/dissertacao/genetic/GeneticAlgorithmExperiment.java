package br.uniriotec.vitor.padilha.dissertacao.genetic;

import jmetal.base.Operator;
import jmetal.base.Solution;
import jmetal.base.SolutionSet;
import jmetal.base.operator.crossover.SinglePointCrossover;
import jmetal.base.operator.mutation.BitFlipMutation;
import jmetal.base.operator.selection.BinaryTournament;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.gGA;
import unirio.experiments.monoobjective.execution.MonoExperiment;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;

/**
 * Class that represents an experiment involving a genetic algorithm
 * 
 * @author marciobarros
 */
public class GeneticAlgorithmExperiment extends MonoExperiment<SoftwareSystem>
{
	private double budgetPercentile;
	FunctionPointsProblem problem;
	
	/**
	 * Initializes the experiment indicating the available percentile of the total budget
	 */
	public GeneticAlgorithmExperiment(double budgetPercentile)
	{
		this.budgetPercentile = budgetPercentile;
	}
	
	/**
	 * Rusn a cycle of the experiment
	 */
	@Override
	protected Solution runCycle(SoftwareSystem instance, int instanceNumber) throws Exception
	{
		problem = new FunctionPointsProblem(instance, budgetPercentile);
		int transactionCount = problem.countTransactions();

		int populationSize = 4 * transactionCount;
		int maxEvaluations = 20 * 4 * transactionCount * transactionCount;
		
		Operator crossover = new SinglePointCrossover();
		crossover.setParameter("probability", 0.8);
		
		Operator mutation = new BitFlipMutation();
		mutation.setParameter("probability", 0.02);

		Operator selection = new BinaryTournament();

		gGA algorithm = new gGA(problem);
		algorithm.setInputParameter("populationSize", populationSize);
		algorithm.setInputParameter("maxEvaluations", maxEvaluations);
		algorithm.addOperator("crossover", crossover);
		algorithm.addOperator("mutation", mutation);
		algorithm.addOperator("selection", selection);
		
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
}