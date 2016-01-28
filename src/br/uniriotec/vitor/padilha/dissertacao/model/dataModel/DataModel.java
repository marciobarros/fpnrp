package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents the data model for a system
 * 
 * @author marcio.barros
 */
public class DataModel
{
	/**
	 * Data functions comprising the data model
	 */
	private List<DataFunction> dataFunctions;
	
	/**
	 * Initializes the data model
	 */
	public DataModel()
	{
		this.dataFunctions = new ArrayList<DataFunction>();
	}
	
	/**
	 * Counts the number of data functions in the model
	 */
	public int countDataFunctions()
	{
		return dataFunctions.size();
	}

	/**
	 * Returns a data function, given its index
	 */
	public DataFunction getDataFunctionIndex(int index) 
	{
		return dataFunctions.get(index);
	}

	/**
	 * Returns the index for a data function in the data model
	 */
	public int getIndexForDataFunction(DataFunction dataFunction)
	{
		return dataFunctions.indexOf(dataFunction);
	}

	/**
	 * Returns a data function, given its name
	 */
	public DataFunction getDataFunctionName(String name) 
	{
		for (DataFunction dataFunction : dataFunctions)
			if (dataFunction.getName().compareToIgnoreCase(name) == 0)
				return dataFunction;
		
		return null;
	}

	/**
	 * Returns a record type, given its name
	 */
	public RecordType getRecordTypeName(String name) 
	{
		for (DataFunction dataFunction : dataFunctions)
		{
			RecordType recordType = dataFunction.getRecordTypeName(name);

			if (recordType != null)
				return recordType;
		}
		
		return null;
	}
	
	/**
	 * Adds a data function to the model
	 */
	public void addDataFunction(DataFunction dataFunction)
	{
		dataFunctions.add(dataFunction);
	}
	
	/**
	 * Removes a data function from the model
	 */
	public void removeDataFunction(int index)
	{
		dataFunctions.remove(index);
	}

	/**
	 * Returns an iterator for the data functions comprising the model
	 */
	public Iterable<DataFunction> getDataFunctions()
	{
		return dataFunctions;
	}
}