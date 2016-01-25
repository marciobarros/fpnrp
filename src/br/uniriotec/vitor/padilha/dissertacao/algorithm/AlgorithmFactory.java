package br.uniriotec.vitor.padilha.dissertacao.algorithm;

import jmetal.base.Algorithm;
import jmetal.base.Operator;
import jmetal.base.Problem;
import jmetal.base.operator.crossover.SinglePointCrossover;
import jmetal.base.operator.mutation.BitFlipMutation;
import jmetal.base.operator.selection.BinaryTournament;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.gGA;
import jmetal.util.JMException;

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

		return null;
	}
}