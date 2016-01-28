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
	private @Getter String name;
	private @Getter String description;
	private @Getter @Setter RecordType recordType;
	private @Getter boolean primaryKey;
	private @Getter String referencedRecordTypeName;
	private @Getter String referencedDataModelElementName;
	private @Getter boolean semanticMeaning;
	private @Getter @Setter RecordType referencedRecordType;
//	private @Getter @Setter boolean flagCanBeDetInTransation;

	public DataElement(String name, String description, RecordType recordType, boolean primaryKey, String referencedDataModelElementName, String referencedRecordTypeName, boolean semanticMeaning) 
	{
		this.name = name;
		this.description = description;
		this.recordType = recordType;
		this.primaryKey = primaryKey;
		this.referencedRecordTypeName = referencedRecordTypeName;
		this.referencedDataModelElementName = referencedDataModelElementName;
		this.semanticMeaning = semanticMeaning;
		this.referencedRecordType = null;
//		this.flagCanBeDetInTransation = false;
	}

//	public boolean canBeDetForTransaction()
//	{
//		return flagCanBeDetInTransation && (!primaryKey || semanticMeaning);
//	}
}