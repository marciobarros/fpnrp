package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Class that represents a data function in a data model
 * 
 * @author Marcio
 */
public class DataFunction
{
	/**
	 * Name of the data function
	 */
	private @Getter String name;

	/**
	 * Type of the data function
	 */
	private @Getter DataFunctionType type;

	/**
	 * List of record types comprising the data function
	 */
	private List<RecordType> recordTypes;
	
	/**
	 * Index of the data function within the data model (to increase calculation speed)
	 */
	private @Getter int index;

	/**
	 * Initializes the data function
	 */
	public DataFunction(String name, DataFunctionType type, int index)
	{
		this.name = name;
		this.type = type;
		this.index = index;
		this.recordTypes = new ArrayList<RecordType>();
	}
	
	/**
	 * Returns the count of record types
	 */
	public int countRecordTypes()
	{
		return recordTypes.size();
	}

	/**
	 * Returns a record type, given its index
	 */
	public RecordType getRecordTypeIndex(int index) 
	{
		return recordTypes.get(index);
	}

	/**
	 * Returns a record type, given its name
	 */
	public RecordType getRecordTypeName(String name) 
	{
		for (RecordType recordType : recordTypes)
			if (recordType.getName().compareToIgnoreCase(name) == 0)
				return recordType;
		
		return null;
	}
	
	/**
	 * Adds a record type to the data function
	 */
	public void addRecordType(RecordType recordType)
	{
		recordTypes.add(recordType);
	}
	
	/**
	 * Removes a record type, given its index
	 */
	public void removeRecordType(int index)
	{
		recordTypes.remove(index);
	}

	/**
	 * Returns an iterator for the record types
	 */
	public Iterable<RecordType> getRecordTypes()
	{
		return recordTypes;
	}
}