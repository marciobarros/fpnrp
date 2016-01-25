package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that represents a record type within a data model element
 * 
 * @author Marcio
 */
public class RecordType
{
	/**
	 * Fields of the record type 
	 */
	private List<DataElement> dets;

	/**
	 * Name of the record type
	 */
	private @Getter @Setter String name;

	/**
	 * ???
	 */
	private @Getter @Setter String extendsRet;

	public RecordType()
	{
		this.dets = new ArrayList<DataElement>();
	}
	
	/**
	 * Counts the number of fields in the record type
	 */
	public int countDataElements()
	{
		return dets.size();
	}

	/**
	 * Returns a field, given its index
	 */
	public DataElement getDataElementIndex(int index) 
	{
		return dets.get(index);
	}
	
	/**
	 * Adds a field to the record type
	 */
	public void addDataElement(DataElement field)
	{
		dets.add(field);
	}
	
	/**
	 * Removes a field from the record type, given its index
	 */
	public void removeDataElement(int index)
	{
		dets.remove(index);
	}
	
	/**
	 * Returns an iterator for the data elements
	 */
	public Iterable<DataElement> getDataElements()
	{
		return dets;
	}

	/**
	 * 
	 */
//	public boolean validate() throws Exception
//	{
//		if (this.getName() == null || this.getName().equals(""))
//			throw new Exception("Nome obrigatório");
//
//		for (DataElement field : getDets())
//			if (!field.validate())
//				return false;
//
//		return true;
//	}

	/**
	 * 
	 */
//	public void charge()
//	{
//		for (DataElement field : getDets())
//			field.charge();
//	}
}