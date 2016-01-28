package br.uniriotec.vitor.padilha.dissertacao;

import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionPointCalculator;
import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionsPointReader;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;

public class MainProgram
{
//	private static final int CICLOS = 50;
//	private static final int LIMITES_PONTOS_POR_FUNCAO = 2000;
	private static final String[] INSTANCES_NAMES = new String[] { "Academico", "GestaoDePessoas", "Parametros", "BolsaDeValores" };
	private static final String INSTANCE_DIRECTORY = "data/instancias/";

	public static void main(String[] args) throws Exception
	{
		FunctionPointCalculator calculator = new FunctionPointCalculator();
		
		for (String instance : INSTANCES_NAMES)
		{
			System.out.print("Processing " + instance + " ... ");
			SoftwareSystem system = new FunctionsPointReader().execute(INSTANCE_DIRECTORY + instance + "/functions-point.xml", INSTANCE_DIRECTORY + instance + "/stakeholders-interest.xml");
			System.out.print(system.getDataModel().countDataFunctions() + " DF ");
			System.out.print(system.getTransactionModel().countTransactionFunctions() + " TF ");
			System.out.println(calculator.calculate(system) + " FP");
			
			// Expectativa 185 FP, 290 FP, 451 FP (pode ser um pouco diferente), 1131 FP
			// TODO depurar o cálculo de FP
		}
		
		System.out.println("FINISHED");
	}
}
