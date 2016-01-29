package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Class that represents a record type within a data function
 * 
 * @author Marcio
 */
public class RecordType
{
	/**
	 * Name of the record type
	 */
	private @Getter String name;

	/**
	 * The data function containing the record type
	 */
	private @Getter DataFunction dataFunction;
	
	/**
	 * Fields of the record type 
	 */
	private List<DataElement> dataElements;
	
	/**
	 * Index of the record type within the data function (to increase calculation speed)
	 */
	private @Getter int index;

	/**
	 * Initializes the record type
	 */
	public RecordType(DataFunction dataFunction, String name, int index)
	{
		this.name = name;
		this.dataFunction = dataFunction;
		this.index = index;
		this.dataElements = new ArrayList<DataElement>();
	}

	/**
	 * Counts the number of data elements
	 */
	public int countDataElements()
	{
		return dataElements.size();
	}

	/**
	 * Returns a data element, given its index
	 */
	public DataElement getDataElementIndex(int index) 
	{
		return dataElements.get(index);
	}

	/**
	 * Returns a data element, given its name
	 */
	public DataElement getDataElementName(String name) 
	{
		for (DataElement dataElement : dataElements)
			if (dataElement.getName().compareToIgnoreCase(name) == 0)
				return dataElement;
		
		return null;
	}
	
	/**
	 * Adds a data element to the record type
	 */
	public void addDataElement(DataElement dataElement)
	{
		dataElements.add(dataElement);
	}
	
	/**
	 * Removes a data element from the record type, given its index
	 */
	public void removeDataElement(int index)
	{
		dataElements.remove(index);
	}
	
	/**
	 * Returns an iterator for the data elements
	 */
	public Iterable<DataElement> getDataElements()
	{
		return dataElements;
	}
}