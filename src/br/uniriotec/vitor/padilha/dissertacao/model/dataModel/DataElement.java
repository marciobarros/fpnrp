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
	private @Getter @Setter String name;
	private @Getter @Setter String ref;
	private @Getter @Setter String description;
	private @Getter @Setter boolean primaryKey;
	private @Getter @Setter boolean hasSemanticMeaning;
	private @Getter @Setter String dataModelElement;
	private @Getter @Setter RecordType retRef;
	private @Getter @Setter boolean flagCanBeDetInTransation;
	private @Getter @Setter boolean implementada;

	public boolean canBeDetForTransaction()
	{
		return isFlagCanBeDetInTransation() && (!isPrimaryKey() || isHasSemanticMeaning());
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
