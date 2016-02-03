package br.uniriotec.vitor.padilha.dissertacao;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Vector;

import unirio.experiments.monoobjective.execution.StreamMonoExperimentListener;
import br.uniriotec.vitor.padilha.dissertacao.calc.FunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.genetic.GeneticAlgorithmExperiment;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.reader.FunctionsPointReader;

public class MainProgram
{
	private static final int CYCLES = 50;
	private static final String[] INSTANCES_NAMES = new String[] { "Academico", "GestaoDePessoas", "Parametros", "BolsaDeValores" };
	private static final String INSTANCE_DIRECTORY = "data/instancias/";

	protected static void showProperties(String... instances) throws Exception
	{
		for (String instance : instances)
		{
			SoftwareSystem system = new FunctionsPointReader().execute(INSTANCE_DIRECTORY + instance + "/functions-point.xml", INSTANCE_DIRECTORY + instance + "/stakeholders-interest.xml");
			FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
			
			System.out.print(instance + ": ");
			System.out.print(system.getTransactionModel().countTransactionFunctions() + " TF, ");
			System.out.print(system.getDataModel().countDataFunctions() + " DF, ");
			System.out.print(calculator.getTotalClassicCost() + " CFP ");
			System.out.println(calculator.getTotalOptimizedCost() + " OFP");
		}

		System.out.println();
	}

	protected static void optimize(String... instances) throws Exception
	{
		FileOutputStream out = new FileOutputStream("saida.txt");
		
		for (String instance : instances)
		{
			SoftwareSystem system = new FunctionsPointReader().execute(INSTANCE_DIRECTORY + instance + "/functions-point.xml", INSTANCE_DIRECTORY + instance + "/stakeholders-interest.xml");

			Vector<SoftwareSystem> systems = new Vector<SoftwareSystem>();
			systems.add(system);
			
			for (int percentile = 10; percentile <= 90; percentile += 10)
			{
				long startTime = System.currentTimeMillis();
				System.out.print("Processing " + instance + " at " + percentile + "% ... ");
				
				GeneticAlgorithmExperiment ga = new GeneticAlgorithmExperiment(percentile, true);
				ga.addListerner(new StreamMonoExperimentListener(new OutputStreamWriter(out), true));
//				ga.addListerner(new StreamMonoExperimentListener(new OutputStreamWriter(System.out), true));
				ga.run(systems, CYCLES);

				long finishTime = System.currentTimeMillis();
				long seconds = (finishTime - startTime) / 1000;
				System.out.println("finished in " + seconds + " ms");
			}
		}

		out.close();
	}

	public static void main(String[] args) throws Exception
	{
		showProperties(INSTANCES_NAMES);
		optimize(INSTANCES_NAMES);		
	}
}