package br.uniriotec.vitor.padilha.dissertacao;

import br.uniriotec.vitor.padilha.dissertacao.engine.FunctionsPointReader;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;

public class MainProgram
{
//	private static final int CICLOS = 50;
//	private static final int LIMITES_PONTOS_POR_FUNCAO = 2000;
	private static final String[] INSTANCES_NAMES = new String[] { "Academico", "GestaoDePessoas", "Parametros", "BolsaDeValores" };
	private static final String INSTANCE_DIRECTORY = "data/instancias/";

	public static void main(String[] args) throws Exception
	{
		for (String instance : INSTANCES_NAMES)
		{
			FunctionPointSystem system = new FunctionsPointReader().execute(INSTANCE_DIRECTORY + instance + "/functions-point.xml", INSTANCE_DIRECTORY + instance + "/stakeholders-interest.xml");

//			FunctionPointSystem functionPointSystem = reader.read();
//			FunctionPointCalculator functionPointCalculator = new FunctionPointCalculator();
//			// Executa os experimentos com algoritmos gen�ticos
//			GenerateReleasesInstancesForExperiment ga = new GenerateReleasesInstancesForExperiment();
//			Algorithms[] algorithms = new Algorithms[1];
//			if (ALGORITHMS.length == 0)
//			{
//				System.out.println("Informe o algoritmo que deseja utilizar:");
//				int algorithmNumber = 0;
//				Scanner in = new Scanner(System.in);
//				System.out.print("Digite ");
//				for (int i = 0; i < Algorithms.values().length; i++)
//				{
//					System.out.print(" " + (i + 1) + " para " + Algorithms.values()[i] + ", ");
//				}
//				System.out.println("");
//				while (algorithmNumber < 1 || algorithmNumber > Algorithms.values().length)
//				{
//					System.out.println("Numero inv�lido, digite novamente: ");
//					algorithmNumber = in.nextInt();
//					System.out.println("");
//				}
//				algorithms[0] = Algorithms.values()[algorithmNumber - 1];
//			} else
//			{
//				algorithms = ALGORITHMS;
//			}
//			//
//			for (int i = 0; i < algorithms.length; i++)
//			{
//				System.out.println("Processando Algoritmo " + algorithms[i].name() + " para inst�ncia " + instance);
//				ga.setListerner(new FunctionsPointDetailsListener("resources/saida" + algorithms[i].name() + ".txt", true, functionPointCalculator, functionPointSystem, CICLOS, algorithms[i]));
//				Vector<FunctionPointSystem> instancias = new Vector<FunctionPointSystem>();
//				instancias.add(functionPointSystem);
//				ga.run(algorithms[i], instancias, functionPointCalculator, LIMITES_PONTOS_POR_FUNCAO, 1, CICLOS);
//			}
		}
	}
}
