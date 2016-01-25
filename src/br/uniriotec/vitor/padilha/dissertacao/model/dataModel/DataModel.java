package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that represents the data model for a system
 * 
 * @author marcio.barros
 */
public class DataModel
{
	/**
	 * Elements comprising the data model
	 */
	private List<DataModelElement> dataModelElements;
	
	/**
	 * Counts the number of elements in the model
	 */
	public int countElements()
	{
		return dataModelElements.size();
	}

	/**
	 * Returns a data model element, given its index
	 */
	public DataModelElement getElementIndex(int index) 
	{
		return dataModelElements.get(index);
	}
	
	/**
	 * Adds an element to the model
	 */
	public void addElement(DataModelElement element)
	{
		dataModelElements.add(element);
	}
	
	/**
	 * Removes an element from the model
	 */
	public void removeElement(int index)
	{
		dataModelElements.remove(index);
	}

	/**
	 * Returns an iterator for the data model elements
	 */
	public Iterable<DataModelElement> getElements()
	{
		return dataModelElements;
	}

	/**
	 * Validates the data model (?)
	 */
//	public boolean validate() throws Exception
//	{
//		for (DataModelElement dataModelElement : getElements())
//			if (!dataModelElement.validate())
//				return false;
//
//		return true;
//	}

	/**
	 * Charges (?) the data model
	 */
//	public void charge()
//	{
//		for (DataModelElement dataModelElement : getElements())
//			dataModelElement.charge();
//	}

	/**
	 * Creates the DOT representation for the data model
	 */
	public String doDot(List<DataModelElement> baseDataElements)
	{
		String result = "";
		Map<String, DataModelElement> baseNames = new HashMap<String, DataModelElement>();
		
		for (DataModelElement dataModelElement : baseDataElements)
		{
			baseNames.put(dataModelElement.getName(), dataModelElement);
		}
		
		for (DataModelElement dataModelElement : getElements())
		{
			result += dataModelElement.getName();
			result += "[";
		
			if (!baseNames.containsKey(dataModelElement.getName()))
			{
				result += "color=red fontcolor=red";
			} 
			else if (!baseNames.get(dataModelElement.getName()).getType().equals(dataModelElement.getType()))
			{
				result += "color=blue fontcolor=blue";
			}
			
			result += " shape=box]\n";
		}
		
		return result;
	}
}