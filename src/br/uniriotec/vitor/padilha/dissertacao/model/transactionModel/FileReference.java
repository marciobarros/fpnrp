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
	 * Fields referenced within the record type 
	 */
	private List<FileReferenceField> fields;
	
	/**
	 * Indicates whether it references all fields 
	 */
	private @Getter @Setter boolean useAllFields;
	
	/**
	 * Initializes the reference to a file
	 */
	public FileReference(RecordType referencedRecordType, boolean useAllFields)
	{
		this.fields = new ArrayList<FileReferenceField>();
		this.referencedRecordType = referencedRecordType;
		this.useAllFields = useAllFields;
	}
	
	/**
	 * Counts the fields referenced in the file
	 */
	public int countFields()
	{
		return fields.size();
	}
	
	/**
	 * Adds a field to the file reference
	 */
	public void addField(FileReferenceField field)
	{
		fields.add(field);
	}

	/**
	 * Returns the fields of the referenced file
	 */
	public Iterable<FileReferenceField> getFields()
	{
		return fields;
	}

	/**
	 * Captures all referenced data elements to a list
	 */
	public void captureDataElements(List<DataElement> dataElements) 
	{
		if (useAllFields)
		{
			for (DataElement dataElement : referencedRecordType.getDataElements())
			{
				if (!dataElement.isPrimaryKey() || dataElement.isSemanticMeaning())
					if (!dataElements.contains(dataElement))
						dataElements.add(dataElement);
			}
			
			return;
		}
		
		for (FileReferenceField field : fields)
		{
			DataElement dataElement = field.getField();
			
			if (!dataElement.isPrimaryKey() || dataElement.isSemanticMeaning())
				if (!dataElements.contains(dataElement))
					dataElements.add(dataElement);
		}
	}
}