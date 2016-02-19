package br.uniriotec.vitor.padilha.dissertacao.calc;

import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

/**
 * Class that calculates function points for the classic model
 * 
 * @author marciobarros
 */
public class ClassicFunctionPointsCalculator extends FunctionPointsCalculator
{
	/**
	 * The cost of each data function
	 */
	private int[] dataFunctionCost;
	
	/**
	 * Bit masks denoting which data functions a transaction depends on
	 */
	private long[] transactionToDataFunctions;

	/**
	 * Initializes the calculator, caching some results
	 */
	public ClassicFunctionPointsCalculator(SoftwareSystem system)
	{
		super(system);
		this.dataFunctionCost = calculateDataFunctionPoints();
		this.transactionToDataFunctions = calculateTransactionDependencyDataFunction();
	}
	
	/**
	 * Calculates the number of function points for each data function
	 */
	private int[] calculateDataFunctionPoints()
	{
		int dataFunctionCount = getSystem().getDataModel().countDataFunctions();
		int[] functionPoints = new int[dataFunctionCount];
		
		for (int i = 0; i < dataFunctionCount; i++)
		{
			DataFunction dataFunction = getSystem().getDataModel().getDataFunctionIndex(i);
			functionPoints[i] = calculateDataFunctionPoints(dataFunction);
		}
		
		return functionPoints;
	}

	/**
	 * Calculates the number of function points associated to a data function
	 */
	private int calculateDataFunctionPoints(DataFunction dataFunction)
	{
		int retCount = dataFunction.countRecordTypes();
		int detCount = countDataFunctionDataElements(dataFunction);
		Complexity complexity = Complexity.calculateDataFunctionComplexity(retCount, detCount);
		return complexity.calculateFunctionPoints(dataFunction.getType());
	}

	/**
	 * Counts the data elements comprising a data function
	 */
	private int countDataFunctionDataElements(DataFunction dataFunction) 
	{
		int detCount = 0;
		
		for (RecordType ret : dataFunction.getRecordTypes())
			for (DataElement det : ret.getDataElements())
				if (det.isAccountableForDataFunction())
					detCount++;
		
		return detCount;
	}

	/**
	 * Calculates a bit mask describing the dependencies of each transaction on data functions
	 */
	private long[] calculateTransactionDependencyDataFunction()
	{
		int transactionCount = getSystem().getTransactionModel().countTransactionFunctions();
		long[] dependencies = new long[transactionCount];
		
		for (int i = 0; i < transactionCount; i++)
		{
			TransactionFunction transaction = getSystem().getTransactionModel().getTransactionFunctionIndex(i);
			
			for (FileReference fileReference : transaction.getFileReferences())
			{
				int dataFunctionIndex = fileReference.getReferencedRecordType().getDataFunction().getIndex();
				dependencies[i] |= (1 << dataFunctionIndex);
			}
		}
		
		return dependencies;
	}

	/**
	 * Calculates the cost of implementing a set of transactions - classic version
	 */
	@Override
	public int calculateCost(boolean[] selectedTransactions)
	{
		selectedTransactions = expandSelectionDueDependencies(selectedTransactions);
		long dataModelBitMask = 0;
		
		for (int i = 0; i < selectedTransactions.length; i++)
			if (selectedTransactions[i])
				dataModelBitMask |= transactionToDataFunctions[i];
		
		int dataModelCost = 0;
		
		for (int i = 0; i < dataFunctionCost.length; i++)
			if ((dataModelBitMask & (1 << i)) != 0)
				dataModelCost += dataFunctionCost[i];
		
		System.out.println("===");

		for (int i = 0; i < dataFunctionCost.length; i++)
		{
			if ((dataModelBitMask & (1 << i)) != 0)
			{
				System.out.println(getSystem().getDataModel().getDataFunctionIndex(i).getName() + " " + dataFunctionCost[i]);
			}
		}
		
		for (int i = 0; i < selectedTransactions.length; i++)
		{
			if (selectedTransactions[i])
			{
				System.out.println(getSystem().getTransactionModel().getTransactionFunctionIndex(i).getName() + " " + transactionCost[i]);
			}
		}
		
		return calculateFunctionPointsTransactionModel(selectedTransactions) + dataModelCost;
	}
	
	/**
	 * Returns the count of classic record types for a data function
	 */
	public int countRecordTypes(DataFunction dataFunction)
	{
		return dataFunction.countRecordTypes();
	}
	
	/**
	 * Returns the count of classic data elements for a data function
	 */
	public int countDataElements(DataFunction dataFunction)
	{
		return countDataFunctionDataElements(dataFunction);
	}
}