package br.uniriotec.vitor.padilha.dissertacao.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
public abstract class FunctionPointsCalculator
{
	private SoftwareSystem system;
	private int[] transactionCost;
	private int[] transactionSatisfaction;
	private @Getter int totalSatisfaction;
	private @Getter int transactionCount;

	/**
	 * Initializes the calculator, caching some results
	 */
	public FunctionPointsCalculator(SoftwareSystem system)
	{
		this.system = system;
		this.transactionCount = system.getTransactionModel().countTransactionFunctions();
		this.transactionCost = calculateTransactionFunctionPoints();
		this.transactionSatisfaction = calculateTransactionSatisfaction();
		this.totalSatisfaction = calculateSatisfaction(allTransactions());
	}

	/**
	 * Returns the system under analysis to the calculator's subclasses
	 */
	protected SoftwareSystem getSystem()
	{
		return system;
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
	 * Calculates the cost of implementing a set of transactions - optimized version
	 */
	public abstract int calculateCost(boolean[] selectedTransactions);

	/**
	 * Calculates the amount of function points required to implement the transaction model alone
	 */
	protected int calculateFunctionPointsTransactionModel(boolean[] selectedTransactions)
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
	 * Creates a string representation of a solution
	 */
	public String toString(boolean[] solution)
	{
		String result = "";
		
		for (int i = 0; i < solution.length; i++)
			result += solution[i] ? "1" : "0";
		
		return "[" + result + "]";
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
	 * Fisher-Yates shuffle algorithm
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