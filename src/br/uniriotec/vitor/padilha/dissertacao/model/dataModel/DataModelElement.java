package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Class that represents an element in a data model
 * 
 * @author Marcio
 */
public class DataModelElement
{
	/**
	 * List of record types for the data model element
	 */
	private List<RecordType> rets;

	/**
	 * Element name
	 */
	private @Getter String name;

	/**
	 * Element type
	 */
	private @Getter DataModelElementType type;

	/**
	 * Value in function points (?)
	 */
//	private @Getter @Setter int functionsPointValue = 0;
	
	/**
	 * Initializes the data model element
	 */
	public DataModelElement(String name, DataModelElementType type)
	{
		this.name = name;
		this.type = type;
		this.rets = new ArrayList<RecordType>();
	}
	
	/**
	 * Initializes the data model element
	 */
	public DataModelElement()
	{
		this.rets = new ArrayList<RecordType>();
	}
	
	/**
	 * Returns the count of data model elements
	 */
	public int countRecordTypes()
	{
		return rets.size();
	}

	/**
	 * Returns a record type, given its index
	 */
	public RecordType getRecordTypeIndex(int index) 
	{
		return rets.get(index);
	}

	/**
	 * Returns a record type, given its name
	 */
	public RecordType getRecordTypeName(String name) 
	{
		for (RecordType ret : rets)
			if (ret.getName().compareToIgnoreCase(name) == 0)
				return ret;
		
		return null;
	}
	
	/**
	 * Adds a record type to the element
	 */
	public void addRecordType(RecordType ret)
	{
		rets.add(ret);
	}
	
	/**
	 * Removes a record type, given its index
	 */
	public void removeRecordType(int index)
	{
		rets.remove(index);
	}

	/**
	 * Returns an iterator for the record types
	 */
	public Iterable<RecordType> getRecordTypes()
	{
		return rets;
	}

	/**
	 * Validate the model
	 */
//	public boolean validate() throws Exception
//	{
//		if (this.getName() == null || this.getName().equals(""))
//			throw new Exception("Nome obrigatório");
//
//		for (RecordType ret : getRecordTypes())
//			if (!ret.validate())
//				return false;
//		
//		return true;
//	}

	/**
	 * Charge the model
	 */
//	public void charge()
//	{
//		for (RecordType ret : getRecordTypes())
//			ret.charge();
//	}
}