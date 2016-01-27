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
	private @Getter boolean primaryKey;
	private @Getter String referencedRecordType;
	private @Getter String referencedDataModelElement;		// ref
	private @Getter boolean semanticMeaning;
	private @Getter @Setter RecordType retRef;
	private @Getter @Setter boolean flagCanBeDetInTransation;
	private @Getter @Setter boolean implementada;

	public DataElement(String name, String description, boolean primaryKey, String referencedRecordType, String referencedDataModelElement, boolean semanticMeaning) 
	{
		this.name = name;
		this.description = description;
		this.primaryKey = primaryKey;
		this.referencedRecordType = referencedRecordType;
		this.referencedDataModelElement = referencedDataModelElement;
		this.semanticMeaning = semanticMeaning;
	}

	public boolean canBeDetForTransaction()
	{
		return flagCanBeDetInTransation && (!primaryKey || semanticMeaning);
	}

//	public boolean validate() throws Exception
//	{
//		if (getName() == null || getName().equals(""))
//			throw new Exception("Nome obrigatório");
//		
//		if (getRef() != null && !getRef().equals(""))
//			if (getRetRef() == null)
//				throw new Exception("Elemento: " + getDataModelElement() + "." + getRef() + " não encontrado");
//
//		return true;
//	}

//	public void charge()
//	{
//		if (getRef() != null && !getRef().equals(""))
//		{
//			if (getDataModelElement() == null || getDataModelElement().equals(""))
//			{
//				setDataModelElement(getRef());
//			}
//			
//			for (DataModelElement modelElement : getParent().getParent().getParent().getDataModelElements())
//			{
//				if (modelElement.getName() != null && modelElement.getName().equals(getDataModelElement()))
//				{
//					for (RET ret : modelElement.getRecordTypes())
//					{
//						if (ret.getName().equals(getRef()))
//						{
//							setRetRef(ret);
//						}
//					}
//				}
//			}
//		}
//	}
}