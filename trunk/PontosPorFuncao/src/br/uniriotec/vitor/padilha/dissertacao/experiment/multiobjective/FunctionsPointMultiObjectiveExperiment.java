package br.uniriotec.vitor.padilha.dissertacao.experiment.multiobjective;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import jmetal.base.Algorithm;
import jmetal.base.Solution;
import jmetal.base.SolutionSet;
import jmetal.util.JMException;
import unirio.experiments.multiobjective.execution.MultiExperiment;
import br.uniriotec.vitor.padilha.dissertacao.algorithm.Algorithms;
import br.uniriotec.vitor.padilha.dissertacao.calculator.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.experiment.IFunctionsPointExperiment;
import br.uniriotec.vitor.padilha.dissertacao.factory.AlgorithmFactory;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.problem.FunctionsPointProblem;
import br.uniriotec.vitor.padilha.dissertacao.problem.multiobjective.FunctionsPointMultiProblem;

public class FunctionsPointMultiObjectiveExperiment extends MultiExperiment<FunctionPointSystem> implements IFunctionsPointExperiment{

	private FunctionPointCalculator functionPointCalculator;
	private Integer numeroTransacoesFaltantes;
	private int numeroMaximoDePontosDeFuncao;
	private Long baseSatisfaction;
	private Algorithms algoritmo;
	private Map<Integer,Map<Integer, Vector<Solution>>> solutions = new HashMap<Integer, Map<Integer,Vector<Solution>>>();
	
	@Override
	public SolutionSet runCycle(FunctionPointSystem instance, int instanceNumber) throws ClassNotFoundException, JMException {
		FunctionsPointProblem problem = createProblem(numeroTransacoesFaltantes,instance, functionPointCalculator,numeroMaximoDePontosDeFuncao, this.baseSatisfaction );
		Algorithm algorithm = AlgorithmFactory.getAlgorithm(algoritmo,problem, numeroTransacoesFaltantes);
		return algorithm.execute();
	}
	@Override
	public void publishCycle(int cycleNumber, int instanceNumber,
			long executionTime, Vector<Solution> cycleFrontier,
			Vector<Solution> instanceFrontier) throws Exception {
		// TODO Auto-generated method stub
		super.publishCycle(cycleNumber, instanceNumber, executionTime, cycleFrontier,
				instanceFrontier);
		
		if(solutions.get(instanceNumber)==null){
			solutions.put(instanceNumber, new HashMap<Integer,  Vector<Solution>>());
		}
		solutions.get(instanceNumber).put(cycleNumber, cycleFrontier);
		System.gc();
		System.out.println("Ciclo:"+cycleNumber);
	}

	protected FunctionsPointProblem createProblem(int numeroDeTransacoes,FunctionPointSystem functionPointSystem, FunctionPointCalculator functionPointCalculator,  int numeroMaximoDePontosDeFuncao, Long baseSatisfaction) throws ClassNotFoundException {
		return new FunctionsPointMultiProblem(functionPointSystem,functionPointCalculator, numeroMaximoDePontosDeFuncao, numeroDeTransacoes, baseSatisfaction);
	}

	public FunctionPointCalculator getFunctionPointCalculator() {
		return functionPointCalculator;
	}

	public void setFunctionPointCalculator(
			FunctionPointCalculator functionPointCalculator) {
		this.functionPointCalculator = functionPointCalculator;
	}

	public Integer getNumeroTransacoesFaltantes() {
		return numeroTransacoesFaltantes;
	}

	public void setNumeroTransacoesFaltantes(Integer numeroTransacoesFaltantes) {
		this.numeroTransacoesFaltantes = numeroTransacoesFaltantes;
	}

	public int getNumeroMaximoDePontosDeFuncao() {
		return numeroMaximoDePontosDeFuncao;
	}

	public void setNumeroMaximoDePontosDeFuncao(int numeroMaximoDePontosDeFuncao) {
		this.numeroMaximoDePontosDeFuncao = numeroMaximoDePontosDeFuncao;
	}

	public Algorithms getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(Algorithms algoritmo) {
		this.algoritmo = algoritmo;
	}
	public Map<Integer, Map<Integer, Vector<Solution>>> getSolutions() {
		return solutions;
	}
	public void setSolutions(Map<Integer, Map<Integer, Vector<Solution>>> solutions) {
		this.solutions = solutions;
	}
	@Override
	public void run2(Vector instances, int cycles) throws Exception {
		run(instances, cycles);		
	}
	public Long getBaseSatisfaction() {
		return baseSatisfaction;
	}
	public void setBaseSatisfaction(Long baseSatisfaction) {
		this.baseSatisfaction = baseSatisfaction;
	}
}