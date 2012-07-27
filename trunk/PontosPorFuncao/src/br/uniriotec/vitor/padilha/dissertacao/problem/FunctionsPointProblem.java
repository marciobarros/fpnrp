package br.uniriotec.vitor.padilha.dissertacao.problem;

import jmetal.base.Problem;
import jmetal.base.Solution;
import jmetal.base.solutionType.BinarySolutionType;
import jmetal.base.variable.Binary;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointFactory;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;

public class FunctionsPointProblem extends Problem{

	/**
	 * 
	 */
	private static final double INFINITO = 100000000000.0;
	private static final long serialVersionUID = 8765690254936090478L;
	private FunctionPointSystem functionPointSystem;
	private FunctionPointCalculator calculator;
	private Integer numeroMaximoDePontosPorFuncao;
	public FunctionsPointProblem(FunctionPointSystem functionPointSystem, FunctionPointCalculator calculator, Integer numeroMaximoDePontosPorFuncao) throws ClassNotFoundException {
		this.calculator =calculator;
		this.functionPointSystem = functionPointSystem;
		this.numeroMaximoDePontosPorFuncao = numeroMaximoDePontosPorFuncao;
		numberOfObjectives_ = 1;
		numberOfVariables_ = 1;
		solutionType_ = new BinarySolutionType(this);
		length_ = new int[numberOfVariables_];
		length_[0] = functionPointSystem.getTransactionModel().getTransactions().size();
	}
	@Override
	public void evaluate(Solution solution) {
		Binary conjuntoTestes = (Binary) solution.getDecisionVariables()[0];
		FunctionPointSystem pontosPorFuncao=null;
		
		pontosPorFuncao = FunctionPointFactory.getFunctionPointSystem(conjuntoTestes.bits_, this.functionPointSystem);
		
		Integer totalDePontosPorFuncao = calculator.calculate(pontosPorFuncao);
		//Compara com o tempo máximo informado pelo usuário. Ex: 200,300 e 400
		if (totalDePontosPorFuncao.intValue() <= numeroMaximoDePontosPorFuncao)
		{
			double coverage = calculator.calculateUserSatisfaction(pontosPorFuncao);
			solution.setObjective(0, -coverage);
		}	
		else
			solution.setObjective(0, INFINITO);		
	}

}