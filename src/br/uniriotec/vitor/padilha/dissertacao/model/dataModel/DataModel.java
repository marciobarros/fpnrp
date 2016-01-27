package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.ArrayList;
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
	private List<DataModelElement> elements;
	
	/**
	 * Initializes the data model
	 */
	public DataModel()
	{
		this.elements = new ArrayList<DataModelElement>();
	}
	
	/**
	 * Counts the number of elements in the model
	 */
	public int countElements()
	{
		return elements.size();
	}

	/**
	 * Returns a data model element, given its index
	 */
	public DataModelElement getElementIndex(int index) 
	{
		return elements.get(index);
	}

	/**
	 * Returns a data model element, given its name
	 */
	public DataModelElement getDataModelElementName(String name) 
	{
		for (DataModelElement element : elements)
			if (element.getName().compareToIgnoreCase(name) == 0)
				return element;
		
		return null;
	}
	
	/**
	 * Adds an element to the model
	 */
	public void addElement(DataModelElement element)
	{
		elements.add(element);
	}
	
	/**
	 * Removes an element from the model
	 */
	public void removeElement(int index)
	{
		elements.remove(index);
	}

	/**
	 * Returns an iterator for the data model elements
	 */
	public Iterable<DataModelElement> getElements()
	{
		return elements;
	}

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