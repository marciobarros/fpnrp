package br.uniriotec.vitor.padilha.dissertacao.algorithm;

import jmetal.base.Problem;
import jmetal.base.Solution;
import jmetal.base.solutionType.BinarySolutionType;
import jmetal.base.variable.Binary;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointFactory;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;

public class FunctionsPointMonoProblem extends Problem
{
	protected static final double INFINITO = 100000000000.0;
	protected static final int INFINITO_INTEIRO = 1000000000;
	private FunctionPointSystem functionPointSystem;
	private FunctionPointCalculator calculator;
	protected Integer numeroMaximoDePontosPorFuncao;
	private Long baseSatisfaction;

	public FunctionsPointMonoProblem(FunctionPointSystem functionPointSystem, FunctionPointCalculator calculator, Integer numeroMaximoDePontosPorFuncao, Integer numeroDeTransacoes, Long baseSatisfaction) throws ClassNotFoundException
	{
		this.calculator = calculator;
		this.functionPointSystem = functionPointSystem;
		this.numeroMaximoDePontosPorFuncao = numeroMaximoDePontosPorFuncao;
		this.baseSatisfaction = baseSatisfaction;
		// this.pontosPorFuncaoAnterior = pontosPorFuncaoAnterior;
		numberOfObjectives_ = 1;
		numberOfVariables_ = 1;
		solutionType_ = new BinarySolutionType(this);
		length_ = new int[numberOfVariables_];
		length_[0] = numeroDeTransacoes;
	}

	protected void adicionaObjetivos(Solution solution, Integer numeroDePontosDeFuncao, double satisfacaoTotal)
	{
		if (numeroDePontosDeFuncao.intValue() <= (numeroMaximoDePontosPorFuncao) && numeroDePontosDeFuncao > 0)
		{
			solution.setObjective(0, -satisfacaoTotal);
		} else
		{
			solution.setObjective(0, -INFINITO);
		}

	}

	@Override
	public void evaluate(Solution solution)
	{
		Binary conjuntoTestes = (Binary) solution.getDecisionVariables()[0];
		FunctionPointSystem pontosPorFuncao = null;

		pontosPorFuncao = FunctionPointFactory.getFunctionPointSystem(conjuntoTestes, this.functionPointSystem);

		// contador++;
		// if(contador%2000==0)
		// System.out.println("Validacao"+contador);
		Integer totalDePontosPorFuncao = calculator.calculate(pontosPorFuncao, 0, null);
		// Compara com o tempo máximo informado pelo usuário. Ex: 200,300 e 400
		double coverage = calculator.calculateUserSatisfactionPercent(pontosPorFuncao, baseSatisfaction);

		adicionaObjetivos(solution, totalDePontosPorFuncao, coverage);

	}
}