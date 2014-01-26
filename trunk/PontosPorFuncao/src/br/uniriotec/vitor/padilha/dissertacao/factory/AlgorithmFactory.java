package br.uniriotec.vitor.padilha.dissertacao.factory;

import jmetal.base.Algorithm;
import jmetal.base.Operator;
import jmetal.base.Problem;
import jmetal.base.operator.crossover.SinglePointCrossover;
import jmetal.base.operator.mutation.BitFlipMutation;
import jmetal.base.operator.selection.BinaryTournament;
import jmetal.base.visitor.neighborhood.BinaryNeighborVisitor;
import jmetal.base.visitor.neighborhood.NeighborVisitor;
import jmetal.metaheuristics.mocell.MOCell;
import jmetal.metaheuristics.nsgaII.NSGAII;
import jmetal.metaheuristics.paes.PAES;
import jmetal.metaheuristics.randomSearch.HillClimbing;
import jmetal.metaheuristics.randomSearch.RandomSearch;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.gGA;
import jmetal.metaheuristics.spea2.SPEA2;
import jmetal.util.JMException;
import br.uniriotec.vitor.padilha.dissertacao.algorithm.Algorithms;

public class AlgorithmFactory {

	public static final Algorithm getAlgorithm(Algorithms algorithmEnum, Problem problem, int numeroDeTransacoes) throws JMException {
		Algorithm algorithm = null;
		int maxEvaluations = numeroDeTransacoes*2;
		maxEvaluations *= maxEvaluations;
		if(maxEvaluations<20)
			maxEvaluations = 20;
		if(algorithmEnum==Algorithms.GENETIC){
			algorithm = new gGA(problem);
			AlgorithmFactory.configureGA(numeroDeTransacoes,algorithm, maxEvaluations);
		}
		else if (algorithmEnum==Algorithms.HILL_CLIMBING) {			
			NeighborVisitor neighborVisitor = new BinaryNeighborVisitor(problem);
			algorithm = new HillClimbing(problem,neighborVisitor,maxEvaluations);
		}
		else if (algorithmEnum==Algorithms.RANDOM) {			
			algorithm = new RandomSearch(problem);
			algorithm.setInputParameter("maxEvaluations", maxEvaluations);			
		}
		else if(algorithmEnum==Algorithms.NSGAII){
			algorithm = new NSGAII(problem);
			AlgorithmFactory.configureGA(numeroDeTransacoes,algorithm, maxEvaluations);
		}
		else if(algorithmEnum==Algorithms.MOCELL){
			algorithm = new MOCell(problem);
			AlgorithmFactory.configureGA(numeroDeTransacoes,algorithm, maxEvaluations);
			AlgorithmFactory.configureMOCell(numeroDeTransacoes,algorithm, maxEvaluations);
		}
		else if(algorithmEnum==Algorithms.PAES){
			algorithm = new PAES(problem);
			AlgorithmFactory.configureGA(numeroDeTransacoes,algorithm, maxEvaluations);
		}
		else if(algorithmEnum==Algorithms.SPEA2){
			algorithm = new SPEA2(problem);
			AlgorithmFactory.configureGA(numeroDeTransacoes,algorithm, maxEvaluations);
			AlgorithmFactory.configureMOCell(numeroDeTransacoes,algorithm, maxEvaluations);
		}
		return algorithm;
	}
	
	private static void configureMOCell(int numeroTransacoes, Algorithm ga, int maxEvaluations) {
		int tamanhoPopulacao = 2 * numeroTransacoes;
		ga.setInputParameter("archiveSize", tamanhoPopulacao/5);
	}
	
	private static void configureGA(int numeroTransacoes, Algorithm ga, int maxEvaluations) {
		int tamanhoPopulacao = 4 * numeroTransacoes;
		Operator selection = new BinaryTournament();		
		Operator crossover = new SinglePointCrossover();
		crossover.setParameter("probability", 0.8);	
		Operator mutation = new BitFlipMutation();
		mutation.setParameter("probability", 0.02);
		ga.setInputParameter("populationSize", tamanhoPopulacao);
		ga.setInputParameter("maxEvaluations", maxEvaluations);
		ga.addOperator("crossover", crossover);
		ga.addOperator("mutation", mutation);
		ga.addOperator("selection", selection);
	}
}