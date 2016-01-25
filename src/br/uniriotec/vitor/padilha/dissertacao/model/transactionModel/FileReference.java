package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;

/**
 * Class that represents a file referenced by a transaction
 * 
 * @author Marcio
 */
public class FileReference
{
	private List<FileReferenceField> fields;
	private @Getter @Setter String name;
	private @Getter @Setter String ret;
	private @Getter @Setter String dataModelElement;
	private @Getter @Setter boolean useAllDets;
	private @Getter @Setter RecordType retRef;
	
	/**
	 * Initializes the reference to a file
	 */
	public FileReference()
	{
		this.fields = new ArrayList<FileReferenceField>();
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

//	public boolean validate() throws Exception
//	{
//		if (getName() == null || getName().equals(""))
//			throw new Exception("Nome obrigatório");
//
//		if (this.retRef == null)
//			throw new Exception("Elemento: " + getDataModelElement() + "." + getRet() + " não encontrado");
//
//		if (getFields() == null && !isUseAllDets())
//			throw new Exception("FTR sem campos: " + getDataModelElement() + "." + getRet() + "");
//
//		return true;
//	}

//	public void charge()
//	{
//		String referencia = getName();
//		if (getRet() != null && !getRet().equals(""))
//		{
//			referencia = getRet();
//		}
//
//		if (getRet() == null || getRet().equals(""))
//		{
//			setRet(getName());
//		}
//		if (getDataModelElement() == null || getDataModelElement().equals(""))
//		{
//			setDataModelElement(getName());
//		}
//		for (DataModelElement modelElement : getParent().getParent().getParent().getDataModel().getDataModelElements())
//		{
//			if (modelElement.getName() != null && modelElement.getName().equals(getDataModelElement()))
//			{
//				for (RET subset : modelElement.getRecordTypes())
//				{
//					if (subset.getName().equals(referencia))
//					{
//						this.retRef = subset;
//					}
//				}
//			}
//		}
//		if (getFields() != null)
//		{
//			for (FTRField ftrField : getFields())
//			{
//				ftrField.charge();
//			}
//		}
//	}
}