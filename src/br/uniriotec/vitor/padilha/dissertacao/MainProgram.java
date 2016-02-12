package br.uniriotec.vitor.padilha.dissertacao;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Vector;

import unirio.experiments.monoobjective.execution.StreamMonoExperimentListener;
import br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.model.MonoExperimentResult;
import br.uniriotec.vitor.padilha.dissertacao.analysis.monoobjective.reader.MonoExperimentFileReader;
import br.uniriotec.vitor.padilha.dissertacao.calc.ClassicFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.calc.OptimizedFunctionPointsCalculator;
import br.uniriotec.vitor.padilha.dissertacao.calc.SolutionSimulator;
import br.uniriotec.vitor.padilha.dissertacao.genetic.GeneticAlgorithmExperiment;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.reader.FunctionsPointReader;
import br.uniriotec.vitor.padilha.dissertacao.utils.MathUtils;

public class MainProgram
{
	private static final int CYCLES = 50;
	private static final String[] INSTANCES_NAMES = new String[] { "Academico", "GestaoDePessoas", "Parametros", "BolsaDeValores" };
	public static final String INSTANCE_DIRECTORY = "data/instancias/";

	protected static void showProperties(String... instances) throws Exception
	{
		for (String instance : instances)
		{
			SoftwareSystem system = new FunctionsPointReader().execute(INSTANCE_DIRECTORY + instance + "/functions-point.xml", INSTANCE_DIRECTORY + instance + "/stakeholders-interest.xml");
			ClassicFunctionPointsCalculator classicCalculator = new ClassicFunctionPointsCalculator(system);
			OptimizedFunctionPointsCalculator optimizedCalculator = new OptimizedFunctionPointsCalculator(system);
			
			System.out.print(instance + ": ");
			System.out.print(system.getTransactionModel().countTransactionFunctions() + " TF, ");
			System.out.print(system.getDataModel().countDataFunctions() + " DF, ");
			System.out.print(classicCalculator.calculateCost(classicCalculator.allTransactions()) + " CFP ");
			System.out.println(optimizedCalculator.calculateCost(optimizedCalculator.allTransactions()) + " OFP");
		}

		System.out.println();
	}

	protected static void simulateDifferences(String... instances) throws Exception
	{
		int numberOfEvaluations = 100000;
		
		for (String instance : instances)
		{
			SoftwareSystem system = new FunctionsPointReader().execute(INSTANCE_DIRECTORY + instance + "/functions-point.xml", INSTANCE_DIRECTORY + instance + "/stakeholders-interest.xml");
			SolutionSimulator simulator = new SolutionSimulator(system);

			for (int proportion = 10; proportion <= 90; proportion += 10)
			{
				System.out.print(instance + "(" + proportion + ")");
				System.out.print("\t" + simulator.calculateDifferentPercentile(numberOfEvaluations, proportion));
				System.out.print("\t" + simulator.calculateSignificantlyDifferentPercentile(numberOfEvaluations, proportion));
				System.out.println("\t" + simulator.calculateAverageDifference(numberOfEvaluations, proportion));
			}
		}

		System.out.println();
	}

	protected static void optimize(String outputFilename, boolean optimizedVersion, String... instances) throws Exception
	{
		FileOutputStream out = new FileOutputStream(outputFilename);
		
		for (String instance : instances)
		{
			SoftwareSystem system = new FunctionsPointReader().execute(INSTANCE_DIRECTORY + instance + "/functions-point.xml", INSTANCE_DIRECTORY + instance + "/stakeholders-interest.xml");

			Vector<SoftwareSystem> systems = new Vector<SoftwareSystem>();
			systems.add(system);
			
			for (int percentile = 10; percentile <= 90; percentile += 10)
			{
				long startTime = System.currentTimeMillis();
				System.out.print("Processing " + instance + " at " + percentile + "% ... ");
				
				GeneticAlgorithmExperiment ga = new GeneticAlgorithmExperiment(percentile, optimizedVersion);
				ga.addListerner(new StreamMonoExperimentListener(new OutputStreamWriter(out), true));
				ga.run(systems, CYCLES);

				long finishTime = System.currentTimeMillis();
				long seconds = (finishTime - startTime) / 1000;
				System.out.println("finished in " + seconds + " s");
			}
		}

		out.close();
	}

	protected static void analyze(String optimizedResultsFilename, String classicResultsFilename) throws Exception
	{
		MonoExperimentFileReader reader = new MonoExperimentFileReader();
		MonoExperimentResult resultOptimized = reader.execute(optimizedResultsFilename);
		MonoExperimentResult resultClassic = reader.execute(classicResultsFilename);
		
		DecimalFormat nf2 = new DecimalFormat("0.00");
		
		for (int i = 0; i < resultOptimized.countInstances(); i++)
		{
			double fitnessOptimized = MathUtils.mean(resultOptimized.getInstanceIndex(i).getObjectives());
			double fitnessClassic = MathUtils.mean(resultClassic.getInstanceIndex(i).getObjectives());
			System.out.println("Instance #" + i + " " + nf2.format(fitnessOptimized) + " " + nf2.format(fitnessClassic));
		}
	}
	
	public static void main(String[] args) throws Exception
	{
//		showProperties(INSTANCES_NAMES);
//		simulateDifferences(INSTANCES_NAMES);
//		optimize("saida fpnrp 50c 80TT.txt", true, INSTANCES_NAMES);	
//		optimize("saida classic 50c 80TT.txt", false, INSTANCES_NAMES);
		analyze("saida fpnrp 50c 80TT.txt", "saida classic 50c 80TT.txt");
	}
}