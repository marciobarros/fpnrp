package br.uniriotec.vitor.padilha.dissertacao.problem.monoobjective;

import jmetal.base.Solution;
import jmetal.base.solutionType.BinarySolutionType;
import br.uniriotec.vitor.padilha.dissertacao.calculator.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.problem.FunctionsPointProblem;

public class FunctionsPointMonoProblem extends FunctionsPointProblem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1393433661495956977L;

	public FunctionsPointMonoProblem(FunctionPointSystem functionPointSystem,
			FunctionPointCalculator calculator,
			Integer numeroMaximoDePontosPorFuncao, Integer numeroDeTransacoes, Long baseSatisfaction)
			throws ClassNotFoundException {
		super(functionPointSystem, calculator, numeroMaximoDePontosPorFuncao,numeroDeTransacoes, baseSatisfaction);
		numberOfObjectives_ = 1;
		numberOfVariables_ = 1;
		solutionType_ = new BinarySolutionType(this);
		length_ = new int[numberOfVariables_];
		length_[0] = numeroDeTransacoes;
	}

	@Override
	protected void adicionaObjetivos(Solution solution,
			Integer numeroDePontosDeFuncao, double satisfacaoTotal) {
		if (numeroDePontosDeFuncao.intValue() <= (numeroMaximoDePontosPorFuncao) && numeroDePontosDeFuncao>0)
		{
			solution.setObjective(0, -satisfacaoTotal);
		}	
		else {
			solution.setObjective(0, -INFINITO);
		}
				
	}
}