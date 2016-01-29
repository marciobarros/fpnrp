package br.uniriotec.vitor.padilha.dissertacao.calc;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
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
	private @Getter int totalCost;
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
		this.totalCost = calculateTotalCost();
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
	private int countTransactionReferencedDataFunctions(TransactionFunction transaction) 
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
	private int countTransactionDataElements(TransactionFunction transaction) 
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
	 * Calculates the total cost for the system
	 */
	private int calculateTotalCost()
	{
		return calculateCost(allTransactions());
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
	 * Calculates the cost of implementing a set of transactions
	 */
	public int calculateCost(boolean[] selectedTransactions)
	{
		selectedTransactions = expandSelectionDueDependencies(selectedTransactions);
		calculateDataModelStatus(dataModelStatus, selectedTransactions);
		return calculateFunctionPointsTransactionModel(selectedTransactions) + calculateDataModelFunctionPoints();
	}
	
	/**
	 * Calculates the status of the data model according to the selected transactions
	 */
	private void calculateDataModelStatus(DataModelStatus dataModelStatus, boolean[] selectedTransactions)
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
	 * Calculates the amount of function points required to implement the data model
	 */
	private int calculateDataModelFunctionPoints()
	{
		int sum = 0;
		
		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction df = system.getDataModel().getDataFunctionIndex(i);
			DataFunctionStatus dfs = dataModelStatus.getDataFunctionStatus(i);
			int retCount = dfs.countRecordTypes();
			int detCount = dfs.countDataElements();
			
			if (detCount > 0)
				sum += Complexity.calculateDataFunctionComplexity(retCount, detCount).calculateFunctionPoints(df.getType());
		}
		
		return sum;
	}

	/**
	 * Calcultes the amount of function points required to implement the transaction model alone
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