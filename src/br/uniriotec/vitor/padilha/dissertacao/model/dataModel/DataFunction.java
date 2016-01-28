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
	 * Initializes the data function
	 */
	public DataFunction(String name, DataFunctionType type)
	{
		this.name = name;
		this.type = type;
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

	/**
	 * Counts the data elements in the data function
	 */
	public int countDataElements() 
	{
		int count = 0;
		
		for (RecordType recordType : recordTypes)
		{
			for (DataElement dataElement : recordType.getDataElements())
			{
				if (!dataElement.isPrimaryKey() || dataElement.isSemanticMeaning())
				{
					if (dataElement.getReferencedRecordType() == null || dataElement.getReferencedRecordType().getDataFunction() != this)
						count++;
				}
			}
		}
		
		return count;
	}
}