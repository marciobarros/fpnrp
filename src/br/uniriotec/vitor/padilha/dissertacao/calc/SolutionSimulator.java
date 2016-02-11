package br.uniriotec.vitor.padilha.dissertacao.calc;

import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;

/**
 * Class that allows checking the differences between the classic and optimized models
 * 
 * @author marciobarros
 */
public class SolutionSimulator
{
	private SoftwareSystem system;
	private ClassicFunctionPointsCalculator classicCalculator;
	private OptimizedFunctionPointsCalculator optimizedCalculator;

	/**
	 * Initializes the simulator
	 */
	public SolutionSimulator(SoftwareSystem system)
	{
		this.system = system;
		this.classicCalculator = new ClassicFunctionPointsCalculator(system);
		this.optimizedCalculator = new OptimizedFunctionPointsCalculator(system);
	}
	
	/**
	 * Check whether a solution has different classic and optimized data functions
	 */
	public boolean checkDifferent(boolean[] solution)
	{
		boolean[] expandedSolution = classicCalculator.expandSelectionDueDependencies(solution);
		optimizedCalculator.calculateDataModelStatus(expandedSolution);
		
		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction dataFunction = system.getDataModel().getDataFunctionIndex(i);
			
			int retCountClassic = classicCalculator.countRecordTypes(dataFunction);
			int detCountClassic = classicCalculator.countDataElements(dataFunction);
			
			int retCountOptimized = optimizedCalculator.countRecordTypes(dataFunction);
			int detCountOptimized = optimizedCalculator.countDataElements(dataFunction);
			
			if (retCountClassic != retCountOptimized)
				return true;
			
			if (detCountClassic != detCountOptimized)
				return true;
		}

		return false;
	}

	/**
	 * Check whether a solution has different classic and optimized data functions (to a point of changing costs)
	 */
	public boolean checkSignificantlyDifferent(boolean[] solution)
	{
		boolean[] expandedSolution = classicCalculator.expandSelectionDueDependencies(solution);
		optimizedCalculator.calculateDataModelStatus(expandedSolution);
		
		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction dataFunction = system.getDataModel().getDataFunctionIndex(i);
			
			int retCountClassic = classicCalculator.countRecordTypes(dataFunction);
			int detCountClassic = classicCalculator.countDataElements(dataFunction);
			Complexity complexityClassic = Complexity.calculateDataFunctionComplexity(retCountClassic, detCountClassic);
			
			int retCountOptimized = optimizedCalculator.countRecordTypes(dataFunction);
			int detCountOptimized = optimizedCalculator.countDataElements(dataFunction);
			Complexity complexityOptimized = Complexity.calculateDataFunctionComplexity(retCountOptimized, detCountOptimized);
			
			if (complexityClassic != complexityOptimized)
			{
//				printDifferences(solution);				
				return true;
			}
		}

		return false;
	}

	/**
	 * Shows the differences between the classic and optimized versions for a solution
	 */
	protected void printDifferences(boolean[] solution)
	{
//		System.out.println("=================");
//		System.out.println(system.getName() + ": " + calculator.toString(solution));
		int sum = 0;
		
		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction dataFunction = system.getDataModel().getDataFunctionIndex(i);
			
			int retCountClassic = classicCalculator.countRecordTypes(dataFunction);
			int detCountClassic = classicCalculator.countDataElements(dataFunction);
			Complexity complexityClassic = Complexity.calculateDataFunctionComplexity(retCountClassic, detCountClassic);
			int functionPointsClassic = complexityClassic.calculateFunctionPoints(dataFunction.getType());
			
			int retCountOptimized = optimizedCalculator.countRecordTypes(dataFunction);
			int detCountOptimized = optimizedCalculator.countDataElements(dataFunction);
			Complexity complexityOptimized = Complexity.calculateDataFunctionComplexity(retCountOptimized, detCountOptimized);
			int functionPointsOptimized = complexityOptimized.calculateFunctionPoints(dataFunction.getType());
			
			if (complexityClassic != complexityOptimized)
			{
				int difference = (functionPointsClassic - functionPointsOptimized);
				sum += difference;
//				System.out.println(difference + " FP " + dataFunction.getName() + " " + retCountClassic + " CRET " + detCountClassic + " CDET " + retCountOptimized + " ORET " + detCountOptimized + " ODET"); 
			}
		}

		System.out.print(sum + " "); 
	}

	/**
	 * Check the average cost difference in function points for the classic and optimized models
	 */
	public int calculateDifference(boolean[] solution)
	{
		boolean[] expandedSolution = classicCalculator.expandSelectionDueDependencies(solution);
		optimizedCalculator.calculateDataModelStatus(expandedSolution);
		int sum = 0;
		
		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction dataFunction = system.getDataModel().getDataFunctionIndex(i);
			
			int retCountClassic = classicCalculator.countRecordTypes(dataFunction);
			int detCountClassic = classicCalculator.countDataElements(dataFunction);
			Complexity complexityClassic = Complexity.calculateDataFunctionComplexity(retCountClassic, detCountClassic);
			int functionPointsClassic = complexityClassic.calculateFunctionPoints(dataFunction.getType());
			
			int retCountOptimized = optimizedCalculator.countRecordTypes(dataFunction);
			int detCountOptimized = optimizedCalculator.countDataElements(dataFunction);
			Complexity complexityOptimized = Complexity.calculateDataFunctionComplexity(retCountOptimized, detCountOptimized);
			int functionPointsOptimized = complexityOptimized.calculateFunctionPoints(dataFunction.getType());
			
			if (functionPointsClassic < functionPointsOptimized)
					System.out.println("ERRO");
			
			sum += (functionPointsClassic - functionPointsOptimized);
		}

		return sum;
	}
	
	/**
	 * Calculates the proportion of solutions that have different classic and optimized data functions
	 */
	public double calculateDifferentPercentile(int numberOfEvaluations, double proportion)
	{
		int count = 0;
		
		for (int i = 0; i < numberOfEvaluations; i++)
		{
			boolean[] random = classicCalculator.randomTransactions(proportion);
			
			if (checkDifferent(random))
				count++;
		}
		
		return (100.0 * count) / numberOfEvaluations;
	}
	
	/**
	 * Calculates the proportion of solutions that have different classic and optimized data functions (to a point of affecting costs)
	 */
	public double calculateSignificantlyDifferentPercentile(int numberOfEvaluations, double proportion)
	{
		int count = 0;
		
		for (int i = 0; i < numberOfEvaluations; i++)
		{
			boolean[] random = classicCalculator.randomTransactions(proportion);
			
			if (checkSignificantlyDifferent(random))
				count++;
		}
		
		return (100.0 * count) / numberOfEvaluations;
	}
	
	/**
	 * Calculates the average difference of costs for the classic and optimized models
	 */
	public double calculateAverageDifference(int numberOfEvaluations, double proportion)
	{
		double sum = 0;
		
		for (int i = 0; i < numberOfEvaluations; i++)
		{
			boolean[] random = classicCalculator.randomTransactions(proportion);
			sum += calculateDifference(random);
		}
		
		return sum / numberOfEvaluations;
	}
}