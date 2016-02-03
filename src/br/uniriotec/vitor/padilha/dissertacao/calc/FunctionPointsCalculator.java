package br.uniriotec.vitor.padilha.dissertacao.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import lombok.Getter;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.Interest;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.Stakeholder;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionDependency;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

/**
 * Class that calculates function points and satisfaction
 * 
 * @author marciobarros
 */
public class FunctionPointsCalculator
{
	private SoftwareSystem system;
	private DataModelStatus dataModelStatus;
	private int[] transactionCost;
	private @Getter int totalOptimizedCost;
	private @Getter int totalClassicCost;
	private int[] transactionSatisfaction;
	private @Getter int totalSatisfaction;
	private @Getter int transactionCount;

	/**
	 * Initializes the calculator, caching some results
	 */
	public FunctionPointsCalculator(SoftwareSystem system)
	{
		this.system = system;
		this.dataModelStatus = new DataModelStatus(system.getDataModel());
		this.transactionCount = system.getTransactionModel().countTransactionFunctions();
		this.transactionCost = calculateTransactionFunctionPoints();
		this.totalOptimizedCost = calculateTotalOptimizedCost();
		this.totalClassicCost = calculateTotalClassicCost();
		this.transactionSatisfaction = calculateTransactionSatisfaction();
		this.totalSatisfaction = calculateTotalSatisfaction();
	}
	
	/**
	 * Calculates the number of function points for each transaction
	 */
	private int[] calculateTransactionFunctionPoints()
	{
		int[] functionPoints = new int[transactionCount];
		
		for (int i = 0; i < transactionCount; i++)
		{
			TransactionFunction transaction = system.getTransactionModel().getTransactionFunctionIndex(i);
			functionPoints[i] = calculateTransactionFunctionPoints(transaction);
		}
		
		return functionPoints;
	}

	/**
	 * Counts the data functions referenced by a transaction
	 */
	public int countTransactionReferencedDataFunctions(TransactionFunction transaction) 
	{
		List<DataFunction> dataFunctions = new ArrayList<DataFunction>();
		
		for (FileReference fileReference : transaction.getFileReferences())
		{
			DataFunction dataFunction = fileReference.getReferencedRecordType().getDataFunction();

			if (!dataFunctions.contains(dataFunction))
				dataFunctions.add(dataFunction);
		}
		
		return dataFunctions.size();
	}

	/**
	 * Counts the data elements referenced by a transaction
	 */
	public int countTransactionDataElements(TransactionFunction transaction) 
	{
		List<DataElement> dataElements = new ArrayList<DataElement>();
		
		for (FileReference fileReference : transaction.getFileReferences())
			captureFileReferencedDataElements(fileReference, dataElements);
		
		return dataElements.size() + transaction.getExtraDataElements() + (transaction.isErrorMessages() ? 1 : 0);
	}

	/**
	 * Captures all data elements referenced by a file reference to a list
	 */
	public void captureFileReferencedDataElements(FileReference fileReference, List<DataElement> dataElements) 
	{
		if (fileReference.isUseAllFields())
		{
			for (DataElement dataElement : fileReference.getReferencedRecordType().getDataElements())
			{
				if (dataElement.isAccountableForTransaction())
					if (!dataElements.contains(dataElement))
						dataElements.add(dataElement);
			}
		}
		else
		{
			for (DataElement dataElement : fileReference.getDataElements())
			{
				if (dataElement.isAccountableForTransaction())
					if (!dataElements.contains(dataElement))
						dataElements.add(dataElement);
			}
		}
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
	 * Calculates the total cost for the system
	 */
	private int calculateTotalOptimizedCost()
	{
		return calculateOptimizedCost(allTransactions());
	}

	/**
	 * Calculates the total cost for the system
	 */
	private int calculateTotalClassicCost()
	{
		return calculateClassicCost(allTransactions());
	}
	
	/**
	 * Calculates stakeholder's satisfaction for each transaction
	 */
	private int[] calculateTransactionSatisfaction()
	{
		int[] satisfaction = new int[transactionCount];
		
		for (Stakeholder stakeholder : system.getStakeholderModel().getStakeholders())
		{
			for (Interest interest : stakeholder.getInterests())
			{
				int index = interest.getTransaction().getIndex();
				satisfaction[index] += stakeholder.getWeight() * interest.getValue();
			}
		}
		
		return satisfaction;
	}
	
	/**
	 * Calculates the total stakeholder's satisfaction for the system
	 */
	private int calculateTotalSatisfaction()
	{
		return calculateSatisfaction(allTransactions());
	}

	/**
	 * Calculates the cost of implementing a set of transactions - optimized version
	 */
	public int calculateOptimizedCost(boolean[] selectedTransactions)
	{
		selectedTransactions = expandSelectionDueDependencies(selectedTransactions);
		calculateDataModelStatus(selectedTransactions);
		return calculateFunctionPointsTransactionModel(selectedTransactions) + calculateDataModelOptimizedFunctionPoints();
	}

	/**
	 * Calculates the cost of implementing a set of transactions - classic version
	 */
	public int calculateClassicCost(boolean[] selectedTransactions)
	{
		selectedTransactions = expandSelectionDueDependencies(selectedTransactions);
		calculateDataModelStatus(selectedTransactions);
		return calculateFunctionPointsTransactionModel(selectedTransactions) + calculateDataModelClassicFunctionPoints();
	}
	
	/**
	 * Calculates the status of the data model according to the selected transactions
	 */
	public void calculateDataModelStatus(boolean[] selectedTransactions)
	{
		dataModelStatus.clear();
		
		for (int i = 0; i < transactionCount; i++)
		{
			if (selectedTransactions[i])
			{
				TransactionFunction transaction = system.getTransactionModel().getTransactionFunctionIndex(i);
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
	private int calculateDataModelOptimizedFunctionPoints()
	{
		int sum = 0;
		
		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction df = system.getDataModel().getDataFunctionIndex(i);
			DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(i);
			int retCount = dfs.countOptimizedRecordTypes();
			int detCount = dfs.countOptimizedDataElements();
			
			if (detCount > 0)
				sum += Complexity.calculateDataFunctionComplexity(retCount, detCount).calculateFunctionPoints(df.getType());
		}
		
		return sum;
	}
	
	/**
	 * Calculates the amount of function points required to implement the data model - classic version
	 */
	private int calculateDataModelClassicFunctionPoints()
	{
		int sum = 0;
		
		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction df = system.getDataModel().getDataFunctionIndex(i);
			DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(i);
			int retCount = dfs.countClassicRecordTypes();
			int detCount = dfs.countClassicDataElements();
			
			if (detCount > 0)
				sum += Complexity.calculateDataFunctionComplexity(retCount, detCount).calculateFunctionPoints(df.getType());
		}
		
		return sum;
	}
	
	/**
	 * Returns the count of classic record types for a data function
	 */
	public int countClassicRecordTypes(DataFunction dataFunction)
	{
		int index = dataFunction.getIndex();
		DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(index);
		return dfs.countClassicRecordTypes();
	}
	
	/**
	 * Returns the count of classic data elements for a data function
	 */
	public int countClassicDataElements(DataFunction dataFunction)
	{
		int index = dataFunction.getIndex();
		DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(index);
		return dfs.countClassicDataElements();
	}
	
	/**
	 * Returns the count of optimized record types for a data function
	 */
	public int countOptimizedRecordTypes(DataFunction dataFunction)
	{
		int index = dataFunction.getIndex();
		DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(index);
		return dfs.countOptimizedRecordTypes();
	}
	
	/**
	 * Returns the count of optimized data elements for a data function
	 */
	public int countOptimizedDataElements(DataFunction dataFunction)
	{
		int index = dataFunction.getIndex();
		DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(index);
		return dfs.countOptimizedDataElements();
	}

	/**
	 * Calculates the amount of function points required to implement the transaction model alone
	 */
	private int calculateFunctionPointsTransactionModel(boolean[] selectedTransactions)
	{
		int sum = 0;
		
		for (int i = 0; i < transactionCount; i++)
		{
			if (selectedTransactions[i])
			{
				sum += transactionCost[i];
			}
		}
		
		return sum;
	}

	/**
	 * Calculates the satisfaction for a set of transactions
	 */
	public int calculateSatisfaction(boolean[] selectedTransactions)
	{
		selectedTransactions = expandSelectionDueDependencies(selectedTransactions);
		int result = 0;
		
		for (int i = 0; i < transactionCount; i++)
			if (selectedTransactions[i])
				result += transactionSatisfaction[i];
		
		return result;
	}

	/**
	 * Calculates the satisfaction for a set of transactions as a percentile of total satisfaction
	 */
	public double calculateSatisfactionPercentile(boolean[] selectedTransactions)
	{
		return (100.0 * calculateSatisfaction(selectedTransactions)) / totalSatisfaction;
	}

	/**
	 * Expand a set of selected transactions to account for transactions they depend on
	 */
	public boolean[] expandSelectionDueDependencies(boolean[] selectedTransactions)
	{
		for (int i = 0; i < transactionCount; i++)
		{
			if (selectedTransactions[i])
			{
				TransactionFunction transaction = system.getTransactionModel().getTransactionFunctionIndex(i);
				selectedTransactions = expandSelectionDueDependencies(transaction, selectedTransactions);
			}
		}
		
		return selectedTransactions;
	}
	
	/**
	 * Handles a transaction while expanding a set of selected transactions to account for transactions they depend on
	 */
	private boolean[] expandSelectionDueDependencies(TransactionFunction transaction, boolean[] selectedTransactions)
	{
		for (TransactionDependency dependency : transaction.getDependencies())
		{
			TransactionFunction referencedTransaction = dependency.getReferencedTransactionFunction();
			int index = referencedTransaction.getIndex();
			
			if (!selectedTransactions[index])
			{
				selectedTransactions[index] = true;
				selectedTransactions = expandSelectionDueDependencies(referencedTransaction, selectedTransactions);
			}
		}
		
		return selectedTransactions;
	}

	/**
	 * Returns the boolean representation for a complete set of transactions 
	 */
	public boolean[] allTransactions()
	{
		boolean[] result = new boolean[transactionCount];

		for (int i = 0; i < transactionCount; i++)
			result[i] = true;
		
		return result;
	}

	/**
	 * Returns the boolean representation for an empty set of transactions 
	 */
	public boolean[] noTransactions()
	{
		boolean[] result = new boolean[transactionCount];

		for (int i = 0; i < transactionCount; i++)
			result[i] = false;
		
		return result;
	}

	/**
	 * Adds a transaction to the boolean representation of a set of transactions 
	 */
	public boolean[] addTransactions(boolean[] selectedTransactions, int index)
	{
		selectedTransactions[index] = true;
		return selectedTransactions;
	}

	/**
	 * Remove a transaction from the boolean representation of a set of transactions 
	 */
	public boolean[] removeTransactions(boolean[] selectedTransactions, int index)
	{
		selectedTransactions[index] = false;
		return selectedTransactions;
	}
	
	/**
	 * Creates the boolean representation of a solution from its string
	 */
	public boolean[] fromString(String solution)
	{
		boolean[] result = new boolean[solution.length() - 2];
		
		for (int i = 1; i < solution.length()-1; i++)
			result[i-1] = (solution.charAt(i) == '1');
		
		return result;
	}
	
	/**
	 * Creates the boolean representation for a random solution
	 */
	public boolean[] randomTransactions()
	{
		boolean[] result = new boolean[transactionCount];
		Random rnd = ThreadLocalRandom.current();
		
		for (int i = 0; i < transactionCount; i++)
			result[i] = rnd.nextBoolean();
		
		return result;
	}
	
	/**
	 * Creates the boolean representation for a random solution
	 */
	public boolean[] randomTransactions(double percentile)
	{	
		int[] positions = new int[transactionCount];
		
		for (int i = 0; i < transactionCount; i++)
			positions[i] = i;
			
		shuffle(positions);
		
		boolean[] result = new boolean[transactionCount];
		int count = (int) Math.floor(percentile * transactionCount / 100.0);
		
		for (int i = 0; i < count; i++)
			result[positions[i]] = true;
		
		return result;
	}

	/**
	 * Fisher–Yates shuffle algorithm
	 */
	private void shuffle(int[] data)
	{
		Random rnd = ThreadLocalRandom.current();
		
		for (int i = data.length-1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			int a = data[index];
			data[index] = data[i];
			data[i] = a;
		}
	}

	/**
	 * Count the number of selected transactions in the boolean representation of a set of transactions
	 */
	public int countTransactions(boolean[] selected)
	{
		int count = 0;
		
		for (int i = 0; i < transactionCount; i++)
			if (selected[i])
				count++;
		
		return count;
	}
}