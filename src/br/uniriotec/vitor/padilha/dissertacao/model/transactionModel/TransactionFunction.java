package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

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
	private @Getter int index;

	/**
	 * Initializes a transaction
	 */
	public TransactionFunction(String name, TransactionFunctionType type, boolean errorMessages, int extraDataElements, int index)
	{
		this.name = name;
		this.type = type;
		this.errorMessages = errorMessages;
		this.extraDataElements = extraDataElements;
		this.dependencies = new ArrayList<TransactionDependency>();
		this.fileReferences = new ArrayList<FileReference>();
		this.index = index;
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
}