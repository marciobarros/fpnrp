package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;

/**
 * Class that represents a transaction
 * 
 * @author Marcio
 */
public class TransactionFunction
{
	private @Getter String name;
	private @Getter TransactionFunctionType type;
	private @Getter boolean errorMessages;
	private @Getter int extraDataElements;
	private List<TransactionDependency> dependencies;
	private List<FileReference> fileReferences;

	/**
	 * Initializes a transaction
	 */
	public TransactionFunction(String name, TransactionFunctionType type, boolean errorMessages, int extraDataElements)
	{
		this.name = name;
		this.type = type;
		this.errorMessages = errorMessages;
		this.extraDataElements = extraDataElements;
		this.dependencies = new ArrayList<TransactionDependency>();
		this.fileReferences = new ArrayList<FileReference>();
	}
	
	/**
	 * Returns a count of the number of dependencies in the transaction
	 */
	public int countDependencies()
	{
		return dependencies.size();
	}
	
	/**
	 * Adds a dependency to the transaction
	 */
	public void addDependency(TransactionDependency dependency)
	{
		dependencies.add(dependency);
	}
	
	/**
	 * Returns the dependencies of the transaction
	 */
	public Iterable<TransactionDependency> getDependencies()
	{
		return dependencies;
	}

	/**
	 * Counts the number of files referenced by the transaction
	 */
	public int countFileReferences()
	{
		return fileReferences.size();
	}

	/**
	 * Returns a file reference, given its index
	 */
	public FileReference getFileReferenceIndex(int index) 
	{
		return fileReferences.get(index);
	}
	
	/**
	 * Adds a reference to a file in the transaction
	 */
	public void addFileReference(FileReference reference)
	{
		fileReferences.add(reference);
	}
	
	/**
	 * Removes a reference to a file in the transaction
	 */
	public void removeFileReference(int index)
	{
		fileReferences.remove(index);
	}
	
	/**
	 * Returns all files referenced by the transaction
	 */
	public Iterable<FileReference> getFileReferences()
	{
		return fileReferences;
	}

	/**
	 * Counts the data functions referenced by the transaction
	 */
	public int countDataFunctions() 
	{
		List<DataFunction> dataFunctions = new ArrayList<DataFunction>();
		
		for (FileReference fileReference : fileReferences)
		{
			DataFunction dataFunction = fileReference.getReferencedRecordType().getDataFunction();

			if (!dataFunctions.contains(dataFunction))
				dataFunctions.add(dataFunction);
		}
		
		return dataFunctions.size();
	}

	/**
	 * Counts the data elements referenced by the transaction
	 */
	public int countDataElements() 
	{
		List<DataElement> dataElements = new ArrayList<DataElement>();
		
		for (FileReference fileReference : fileReferences)
			fileReference.captureDataElements(dataElements);
		
		return dataElements.size() + extraDataElements + (errorMessages ? 1 : 0);
	}
}