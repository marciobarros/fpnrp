package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RET;

public class FTR
{
	private List<FTRField> fields;
	private @Getter @Setter String name;
	private @Getter @Setter String ret;
	private @Getter @Setter String dataModelElement;
	private @Getter @Setter boolean useAllDets;
	private @Getter @Setter RET retRef;

	public Iterable<FTRField> getFields()
	{
		return fields;
	}

	public boolean validate() throws Exception
	{
		if (getName() == null || getName().equals(""))
			throw new Exception("Nome obrigatório");

		if (this.retRef == null)
			throw new Exception("Elemento: " + getDataModelElement() + "." + getRet() + " não encontrado");

		if (getFields() == null && !isUseAllDets())
			throw new Exception("FTR sem campos: " + getDataModelElement() + "." + getRet() + "");

		return true;
	}

	public void charge()
	{
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
	}
}