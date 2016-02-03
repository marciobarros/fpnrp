package br.uniriotec.vitor.padilha.dissertacao.calc;

import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

public class SolutionPublisher
{
	public StringBuffer publish(SoftwareSystem system, boolean[] solution)
	{
		StringBuffer sb = new StringBuffer();
		
		FunctionPointsCalculator calculator = new FunctionPointsCalculator(system);
		boolean[] expandedSolution = calculator.expandSelectionDueDependencies(solution);
		
//		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
//		{
//			DataFunction dataFunction = system.getDataModel().getDataFunctionIndex(i);
//			int retCount = calculator.countDataFunctionRecordTypes(dataFunction);
//			int detCount = calculator.countDataFunctionDataElements(dataFunction);
//			Complexity complexity = calculator.calculateDataFunctionComplexity(dataFunction);
//			int fp = calculator.calculateDataFunctionFunctionPoints(dataFunction);
//			sb.append("DF\t" + dataFunction.getType().name() + "\t" + dataFunction.getName() + "\t" + retCount + " RET\t" + detCount + " DET\t" + complexity.name() + "\t" + fp + "\n");
//		}
//		
//		for (int i = 0; i < system.getTransactionModel().countTransactionFunctions(); i++)
//		{
//			if (expandedSolution[i])
//			{
//				TransactionFunction transaction = system.getTransactionModel().getTransactionFunctionIndex(i);
//				int ftrCount = calculator.countTransactionReferencedDataFunctions(transaction);
//				int detCount = calculator.countTransactionDataElements(transaction);
//				Complexity complexity = calculator.calculateTransactionComplexity(transaction);
//				int fp = calculator.calculateTransactionFunctionPoints(transaction);
//				sb.append("TF\t" + transaction.getType().name() + "\t" + transaction.getName() + "\t" + ftrCount + " FTR\t" + detCount + " DET\t" + complexity.name() + "\t" + fp + "\n");
//			}
//		}
		
		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction dataFunction = system.getDataModel().getDataFunctionIndex(i);
			int retCountClassic = calculator.countClassicRecordTypes(dataFunction);
			int detCountClassic = calculator.countClassicDataElements(dataFunction);
			int retCountOptimized = calculator.countOptimizedRecordTypes(dataFunction);
			int detCountOptimized = calculator.countOptimizedDataElements(dataFunction);
			sb.append("DF\t" + dataFunction.getType().name() + "\t" + dataFunction.getName() + "\t" + retCountClassic + "\t" + detCountClassic + " DET\t" + retCountOptimized + "\t" + detCountOptimized + "\n");
		}
		
		for (int i = 0; i < system.getTransactionModel().countTransactionFunctions(); i++)
		{
			if (expandedSolution[i])
			{
				TransactionFunction transaction = system.getTransactionModel().getTransactionFunctionIndex(i);
				int ftrCount = calculator.countTransactionReferencedDataFunctions(transaction);
				int detCount = calculator.countTransactionDataElements(transaction);
				sb.append("TF\t" + transaction.getType().name() + "\t" + transaction.getName() + "\t" + ftrCount + " FTR\t" + detCount + " DET\n");
			}
		}
		
		return sb;
	}
}