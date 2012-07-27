package br.uniriotec.vitor.padilha.dissertacao.experiment;

import jmetal.base.Algorithm;
import jmetal.base.Operator;
import jmetal.base.Solution;
import jmetal.base.SolutionSet;
import jmetal.base.operator.crossover.SinglePointCrossover;
import jmetal.base.operator.mutation.BitFlipMutation;
import jmetal.base.operator.selection.BinaryTournament;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.gGA;
import unirio.experiments.monoobjective.execution.MonoExperiment;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.problem.FunctionsPointProblem;

public class FunctionsPointGAExperiment extends MonoExperiment<FunctionPointSystem>{

	private FunctionPointSystem functionPointSystem;
	private FunctionPointCalculator functionPointCalculator;
	private Integer maxFunctionsPointValue;
	@Override
	protected Solution runCycle(FunctionPointSystem instance, int instanceNumber)
			throws Exception {
		this.functionPointSystem = instance;
		FunctionsPointProblem problem = criaProblema();
		int numeroTransacoes = instance.getTransactionModel().getTransactions().size();
	
		
		int tamanhoPopulacao = 2 * numeroTransacoes;
		//int tamanhoPopulacao = 2 * 2;
		//int maxEvaluations = 100 * tamanhoPopulacao * tamanhoPopulacao;
		int maxEvaluations = tamanhoPopulacao * tamanhoPopulacao;
		
		System.out.println("Total validações: "+maxEvaluations);
	
		Operator crossover = new SinglePointCrossover();
		crossover.setParameter("probability", 0.8);
	
		Operator mutation = new BitFlipMutation();
		mutation.setParameter("probability", 0.02);
	
		Operator selection = new BinaryTournament();
				
		Algorithm ga = new gGA(problem);		
		ga.setInputParameter("populationSize", tamanhoPopulacao);
		ga.setInputParameter("maxEvaluations", maxEvaluations);
		ga.addOperator("crossover", crossover);
		ga.addOperator("mutation", mutation);
		ga.addOperator("selection", selection);
		
		SolutionSet solutions = ga.execute();
		return solutions.get(0);
	}
	
	protected FunctionsPointProblem criaProblema() throws ClassNotFoundException {
		
		return new FunctionsPointProblem(this.functionPointSystem,this.functionPointCalculator, getMaxFunctionsPointValue());
	}
	public FunctionPointCalculator getFunctionPointCalculator() {
		return functionPointCalculator;
	}
	public void setFunctionPointCalculator(
			FunctionPointCalculator functionPointCalculator) {
		this.functionPointCalculator = functionPointCalculator;
	}
	public Integer getMaxFunctionsPointValue() {
		return maxFunctionsPointValue;
	}
	public void setMaxFunctionsPointValue(Integer maxFunctionsPointValue) {
		this.maxFunctionsPointValue = maxFunctionsPointValue;
	}

}