package br.uniriotec.vitor.padilha.dissertacao.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests.StakeholderInterests;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReferenceField;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;

public class FunctionPointSystem
{
	private @Getter @Setter String name;
	private @Getter	DataModel dataModel;
	private @Getter TransactionModel transactionModel;
	private @Getter StakeholderInterests stakeholderInterests;
	
	public FunctionPointSystem()
	{
		this.name = "";
		this.dataModel = new DataModel();
		this.transactionModel = new TransactionModel();
		this.stakeholderInterests = new StakeholderInterests();
	}

//	public boolean validate() throws Exception
//	{
//		if (this.getDataModel().validate() && this.getTransactionModel().validate())
//			return true;
//
//		return false;
//	}

//	public void charge()
//	{
//		this.getDataModel().charge();
//		this.getTransactionModel().charge();
//	}

	public void clear()
	{
		clearUnusedFields();
		clearUnusedRecordTypes();
	}

	/**
	 * Removes all unused record types from the model
	 */
	private void clearUnusedRecordTypes()
	{
		for (int i = dataModel.countElements()-1; i >= 0; i--)
		{
			DataModelElement dataModelElement = dataModel.getElementIndex(i);
			
			for (int j = dataModelElement.countRecordTypes()-1; j >= 0; j--)
			{
				RecordType ret = dataModelElement.getRecordTypeIndex(j);
				
				if (ret.countDataElements() == 0)
					dataModelElement.removeRecordType(j);
			}
			
			if (dataModelElement.countRecordTypes() == 0)
				dataModel.removeElement(i);
		}
	}

	/**
	 * Removes all unused fields from record types in the model
	 */
	private void clearUnusedFields()
	{
		List<DataElement> usedFields = new ArrayList<DataElement>();
		
		for (int i = transactionModel.countTransactions()-1; i >= 0; i--)
		{
			Transaction transaction = transactionModel.getTransactionIndex(i);
			
			for (int j = transaction.countFileReferences()-1; j >= 0; j--)
			{
				FileReference fileReference = transaction.getFileReferenceIndex(j);
				
				if (fileReference.isUseAllDets())
				{
					if (fileReference.getRetRef().getDataElements() != null)
					{
						for (DataElement field : fileReference.getRetRef().getDataElements())
							usedFields.add(field);
					}
				} 
				else
				{
					for (FileReferenceField field : fileReference.getFields())
						usedFields.add(field.getField());
				}
			}
		}
		
		for (DataModelElement dataModelElement : dataModel.getElements())
		{
			for (RecordType recordType : dataModelElement.getRecordTypes())
			{
				for (int i = recordType.countDataElements()-1; i >= 0; i--)
				{
					DataElement dataElement = recordType.getDataElementIndex(i);
					
					if (!usedFields.contains(dataElement))
						recordType.removeDataElement(i);
				}
			}
		}

	}

	public String doDot(FunctionPointSystem baseFunctionPointSystem, boolean showDataModel)
	{
		String returnValue = "digraph teste {\n";
		
//		if (showDataModel)
//			returnValue += this.dataModel.doDot(baseFunctionPointSystem.getDataModel().getElements());
//
//		returnValue += this.transactionModel.doDot(baseFunctionPointSystem.getTransactionModel().getTransactions(), showDataModel);

		returnValue += "}";
		return returnValue;
	}
}