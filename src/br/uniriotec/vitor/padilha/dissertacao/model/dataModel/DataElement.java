package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that represents a field in a data model
 * 
 * @author marcio.barros
 */
public class DataElement
{
	/**
	 * Data element name
	 */
	private @Getter String name;
	
	/**
	 * A description for the data element
	 */
	private @Getter String description;
	
	/**
	 * Record type containing the data element
	 */
	private @Getter RecordType recordType;
	
	/**
	 * Indicates whether the data element is a primary key
	 */
	private @Getter boolean primaryKey;
	
	/**
	 * The name of the record type referenced by the data element (temporary, used while reading the model)
	 */
	private @Getter String referencedRecordTypeName;

	/**
	 * The name of the data function containing the record type referenced by the data element (temporary, used while reading the model)
	 */
	private @Getter String referencedDataModelElementName;

	/**
	 * The record type referenced by the data element
	 */
	private @Getter @Setter RecordType referencedRecordType;

	/**
	 * Indicates whether the data element has semantic meaning (for primary keys only)
	 */
	private @Getter boolean semanticMeaning;
	
	/**
	 * Index of the data element within the record type (to increase calculation speed)
	 */
	private @Getter int index;

	/**
	 * Initializes the data element
	 */
	public DataElement(String name, String description, RecordType recordType, boolean primaryKey, String referencedDataModelElementName, String referencedRecordTypeName, boolean semanticMeaning, int index) 
	{
		this.name = name;
		this.description = description;
		this.recordType = recordType;
		this.primaryKey = primaryKey;
		this.referencedRecordTypeName = referencedRecordTypeName;
		this.referencedDataModelElementName = referencedDataModelElementName;
		this.semanticMeaning = semanticMeaning;
		this.referencedRecordType = null;
		this.index = index;
	}
	
	/**
	 * Determines whether the data element is accountable for transactions
	 */
	public boolean isAccountableForTransaction()
	{
		if (referencedRecordType != null)
			return semanticMeaning || referencedRecordType.getDataFunction() != recordType.getDataFunction();
		
		return (!primaryKey || semanticMeaning);
	}
	
	/**
	 * Determines whether the data element is accountable for data functions
	 */
	public boolean isAccountableForDataFunction()
	{
		if (primaryKey)
			return semanticMeaning;
		
		if (referencedRecordType != null)
			return semanticMeaning || referencedRecordType.getDataFunction() != recordType.getDataFunction();
		
		return true;
	}
}