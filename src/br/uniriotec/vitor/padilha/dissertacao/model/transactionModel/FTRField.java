package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import lombok.Data;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DET;

public @Data class FTRField
{
	private String name;
	private DET field;

	public boolean validate() throws Exception
	{
		if (getName() == null || getName().equals(""))
			throw new Exception("Nome obrigatório");

//		if (getField() == null)
//			throw new Exception("Campo não encontrado: " + getParent().getName() + " - " + getName());

		return true;
	}

	public void charge()
	{
//		for (DataModelElement dataModelElement : getParent().getParent().getParent().getParent().getDataModel().getDataModelElements())
//		{
//			if (dataModelElement.getName().equals(getParent().getDataModelElement()))
//			{
//				for (RET ret : dataModelElement.getRecordTypes())
//				{
//					if (ret.getName().equals(getParent().getRet()))
//					{
//						for (DET field : ret.getDets())
//						{
//							if (field.getName().equals(getName()))
//							{
//								setField(field);
//							}
//						}
//					}
//				}
//			}
//		}
	}
}