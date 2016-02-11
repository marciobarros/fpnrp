package br.uniriotec.vitor.padilha.dissertacao.calc;

import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

/**
 * Class that calculates function points and satisfaction
 * 
 * @author marciobarros
 */
public class OptimizedFunctionPointsCalculator extends FunctionPointsCalculator
{
	private DataModelStatus dataModelStatus;

	/**
	 * Initializes the calculator, caching some results
	 */
	public OptimizedFunctionPointsCalculator(SoftwareSystem system)
	{
		super(system);
		this.dataModelStatus = new DataModelStatus(getSystem().getDataModel());
	}

	/**
	 * Calculates the complexity of a transaction
	 */
	public Complexity calculateTransactionComplexity(TransactionFunction transaction)
	{
		int ftrCount = countTransactionReferencedDataFunctions(transaction);
		int detCount = countTransactionDataElements(transaction);
		return Complexity.calculateTransactionComplexity(ftrCount, detCount, transaction.getType());
	}

	/**
	 * Calculates the number of function points associated to a transaction
	 */
	public int calculateTransactionFunctionPoints(TransactionFunction transaction)
	{
		int ftrCount = countTransactionReferencedDataFunctions(transaction);
		int detCount = countTransactionDataElements(transaction);
		Complexity complexity = Complexity.calculateTransactionComplexity(ftrCount, detCount, transaction.getType());
		return complexity.calculateFunctionPoints(transaction.getType());
	}

	/**
	 * Counts the record types comprising a data function
	 */
	public int countDataFunctionRecordTypes(DataFunction dataFunction) 
	{
		return dataFunction.countRecordTypes();
	}

	/**
	 * Counts the data elements comprising a data function
	 */
	public int countDataFunctionDataElements(DataFunction dataFunction) 
	{
		int detCount = 0;
		
		for (RecordType ret : dataFunction.getRecordTypes())
			for (DataElement det : ret.getDataElements())
				if (det.isAccountableForDataFunction())
					detCount++;
		
		return detCount;
	}

	/**
	 * Calculates the complexity of a data function
	 */
	public Complexity calculateDataFunctionComplexity(DataFunction dataFunction)
	{
		int retCount = countDataFunctionRecordTypes(dataFunction);
		int detCount = countDataFunctionDataElements(dataFunction);
		return Complexity.calculateDataFunctionComplexity(retCount, detCount);
	}

	/**
	 * Calculates the number of function points associated to a data function
	 */
	public int calculateDataFunctionFunctionPoints(DataFunction dataFunction)
	{
		int retCount = countDataFunctionRecordTypes(dataFunction);
		int detCount = countDataFunctionDataElements(dataFunction);
		Complexity complexity = Complexity.calculateDataFunctionComplexity(retCount, detCount);
		return complexity.calculateFunctionPoints(dataFunction.getType());
	}

	/**
	 * Calculates the cost of implementing a set of transactions - optimized version
	 */
	@Override
	public int calculateCost(boolean[] selectedTransactions)
	{
		selectedTransactions = expandSelectionDueDependencies(selectedTransactions);
		calculateDataModelStatus(selectedTransactions);
		return calculateFunctionPointsTransactionModel(selectedTransactions) + calculateDataModelFunctionPoints();
	}
	
	/**
	 * Calculates the status of the data model according to the selected transactions
	 */
	public void calculateDataModelStatus(boolean[] selectedTransactions)
	{
		int transactionCount = getTransactionCount();
		this.dataModelStatus.clear();
		
		for (int i = 0; i < transactionCount; i++)
		{
			if (selectedTransactions[i])
			{
				TransactionFunction transaction = getSystem().getTransactionModel().getTransactionFunctionIndex(i);
				markUsedDataElements(dataModelStatus, transaction);
			}
		}		
	}

	/**
	 * Marks the data elements used by a transaction function
	 */
	private void markUsedDataElements(DataModelStatus dataModelStatus, TransactionFunction transaction)
	{
		for (FileReference reference : transaction.getFileReferences())
		{
			if (reference.isUseAllFields())
			{
				for (DataElement dataElement : reference.getReferencedRecordType().getDataElements())
				{
					if (dataElement.isAccountableForDataFunction())
						dataModelStatus.useDataElement(dataElement);
				}
			}
			else
			{
				for (DataElement dataElement : reference.getDataElements())
				{
					if (dataElement.isAccountableForDataFunction())
						dataModelStatus.useDataElement(dataElement);
				}
			}
		}
	}
	
	/**
	 * Calculates the amount of function points required to implement the data model - optimized version
	 */
	private int calculateDataModelFunctionPoints()
	{
		int sum = 0;
		
		for (int i = 0; i < getSystem().getDataModel().countDataFunctions(); i++)
		{
			DataFunction df = getSystem().getDataModel().getDataFunctionIndex(i);
			DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(i);
			int retCount = dfs.countRecordTypes();
			int detCount = dfs.countDataElements();
			
			if (detCount > 0)
				sum += Complexity.calculateDataFunctionComplexity(retCount, detCount).calculateFunctionPoints(df.getType());
		}
		
		return sum;
	}
	
	/**
	 * Returns the count of optimized record types for a data function
	 */
	public int countRecordTypes(DataFunction dataFunction)
	{
		int index = dataFunction.getIndex();
		DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(index);
		return dfs.countRecordTypes();
	}
	
	/**
	 * Returns the count of optimized data elements for a data function
	 */
	public int countDataElements(DataFunction dataFunction)
	{
		int index = dataFunction.getIndex();
		DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(index);
		return dfs.countDataElements();
	}
}