package br.uniriotec.vitor.padilha.dissertacao.factory;

import jmetal.base.Algorithm;
import jmetal.base.Operator;
import jmetal.base.Problem;
import jmetal.base.operator.crossover.SinglePointCrossover;
import jmetal.base.operator.mutation.BitFlipMutation;
import jmetal.base.operator.selection.BinaryTournament;
import jmetal.base.visitor.neighborhood.BinaryNeighborVisitor;
import jmetal.base.visitor.neighborhood.NeighborVisitor;
import jmetal.metaheuristics.randomSearch.HillClimbing;
import jmetal.metaheuristics.randomSearch.RandomSearch;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.gGA;
import jmetal.util.JMException;
import br.uniriotec.vitor.padilha.dissertacao.algorithm.Algorithms;

public class AlgorithmFactory
{
	public static final Algorithm getAlgorithm(Algorithms algorithmEnum, Problem problem, int numeroDeTransacoes) throws JMException
	{
		int maxEvaluations = Math.min(4 * numeroDeTransacoes * numeroDeTransacoes, 20);
		
		if (algorithmEnum == Algorithms.GENETIC)
		{
			gGA algorithm = new gGA(problem);
			Operator crossover = new SinglePointCrossover();
			crossover.setParameter("probability", 0.8);
			Operator mutation = new BitFlipMutation();
			mutation.setParameter("probability", 0.02);
			algorithm.setInputParameter("populationSize", 4 * numeroDeTransacoes);
			algorithm.setInputParameter("maxEvaluations", maxEvaluations);
			algorithm.addOperator("crossover", crossover);
			algorithm.addOperator("mutation", mutation);
			algorithm.addOperator("selection", new BinaryTournament());
			return algorithm;
		}
		
		if (algorithmEnum == Algorithms.HILL_CLIMBING)
		{
			NeighborVisitor neighborVisitor = new BinaryNeighborVisitor(problem);
			HillClimbing algorithm = new HillClimbing(problem, neighborVisitor, maxEvaluations);
			return algorithm;
		} 
		
		if (algorithmEnum == Algorithms.RANDOM)
		{
			RandomSearch algorithm = new RandomSearch(problem);
			algorithm.setInputParameter("maxEvaluations", maxEvaluations);
			return algorithm;
		}

		return null;
	}
}