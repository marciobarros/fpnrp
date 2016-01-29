package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;

/**
 * Class that represents a file referenced by a transaction
 * 
 * @author Marcio
 */
public class FileReference
{
	/**
	 * Record type referenced by the file reference
	 */
	private @Getter @Setter RecordType referencedRecordType;
	
	/**
	 * Data elements referenced within the record type 
	 */
	private List<DataElement> dataElements;
	
	/**
	 * Indicates whether it references all fields 
	 */
	private @Getter @Setter boolean useAllFields;
	
	/**
	 * Initializes the reference to a file
	 */
	public FileReference(RecordType referencedRecordType, boolean useAllFields)
	{
		this.dataElements = new ArrayList<DataElement>();
		this.referencedRecordType = referencedRecordType;
		this.useAllFields = useAllFields;
	}
	
	/**
	 * Counts the fields referenced in the file
	 */
	public int countDataElements()
	{
		return dataElements.size();
	}
	
	/**
	 * Adds a data element referenced in the file
	 */
	public void addDataElement(DataElement field)
	{
		dataElements.add(field);
	}

	/**
	 * Returns the data elements of the referenced file
	 */
	public Iterable<DataElement> getDataElements()
	{
		return dataElements;
	}
}