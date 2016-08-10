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
	 * Calculates the complexity associated to a data function
	 */
	private Complexity calculateDataFunctionComplexity(DataFunction dataFunction)
	{
		int retCount = dataFunction.countRecordTypes();
		int detCount = countDataFunctionDataElements(dataFunction);
		return Complexity.calculateDataFunctionComplexity(retCount, detCount);
	}

	/**
	 * Calculates the number of function points associated to a data function
	 */
	private int calculateDataFunctionPoints(DataFunction dataFunction)
	{
		Complexity complexity = calculateDataFunctionComplexity(dataFunction);
		return complexity.calculateFunctionPoints(dataFunction.getType());
	}

	/**
	 * Checks whether a data function is required
	 */
	@Override
	protected boolean isDataFunctionRequired(DataFunction dataFunction, boolean[] solution)
	{
		boolean[] selectedTransactions = expandSelectionDueDependencies(solution);
		long dataModelBitMask = 0;
		
		for (int i = 0; i < selectedTransactions.length; i++)
			if (selectedTransactions[i])
				dataModelBitMask |= transactionToDataFunctions[i];

		return ((dataModelBitMask & (1 << dataFunction.getIndex())) != 0);
	}

	/**
	 * Counts the record types comprising a data function
	 */
	@Override
	protected int countDataFunctionRecordTypes(DataFunction dataFunction) 
	{
		return dataFunction.countRecordTypes();
	}

	/**
	 * Counts the data elements comprising a data function
	 */
	@Override
	protected int countDataFunctionDataElements(DataFunction dataFunction) 
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
		
		DetailedReport report = new DetailedReport();

		for (int i = 0; i < dataFunctionCost.length; i++)
			if ((dataModelBitMask & (1 << i)) != 0)
			{
				DataFunction df = getSystem().getDataModel().getDataFunctionIndex(i);
				DataFunctionReport dfr = report.addDataFunction(df, dataFunctionCost[i]);
				dfr.setRet(countRecordTypes(df));
				dfr.setDet(countDataElements(df));
			}
		
		for (int i = 0; i < selectedTransactions.length; i++)
			if (selectedTransactions[i])
			{
				TransactionFunction tf = getSystem().getTransactionModel().getTransactionFunctionIndex(i);
				TransactionFunctionReport tfr = report.addTransactionFunction(tf, transactionCost[i]);
				tfr.setFtr(countTransactionReferencedDataFunctions(tf));
				tfr.setDet(countTransactionDataElements(tf));
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

	/**
	 * Counts the number of data functions with a given complexity
	 */
	public int countDataFunctions(SoftwareSystem system, Complexity c) 
	{
		int count = 0;
		
		for (DataFunction df : getSystem().getDataModel().getDataFunctions())
		{
			Complexity c1 = calculateDataFunctionComplexity(df);
			
			if (c1 == c)
				count++;
		}
		
		return count;
	}

	/**
	 * Counts the number of transaction functions with a given complexity
	 */
	public int countTransactionFunctions(SoftwareSystem system, Complexity c) 
	{
		int count = 0;
		
		for (TransactionFunction tf : getSystem().getTransactionModel().getTransactionFunctions())
		{
			Complexity c1 = calculateTransactionComplexity(tf);
			
			if (c1 == c)
				count++;
		}
		
		return count;
	}
}