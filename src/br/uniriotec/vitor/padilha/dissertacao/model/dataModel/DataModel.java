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
	 * Returns an iterator for the data model elements
	 */
	public Iterable<DataModelElement> getDataModelElements()
	{
		return dataModelElements;
	}

	/**
	 * Validates the data model (?)
	 */
	public boolean validate() throws Exception
	{
		for (DataModelElement dataModelElement : getDataModelElements())
			if (!dataModelElement.validate())
				return false;

		return true;
	}

	/**
	 * Charges (?) the data model
	 */
	public void charge()
	{
		for (DataModelElement dataModelElement : getDataModelElements())
			dataModelElement.charge();
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
		
		for (DataModelElement dataModelElement : getDataModelElements())
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