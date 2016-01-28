package br.uniriotec.vitor.padilha.dissertacao.model;

import lombok.Getter;
import lombok.Setter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.StakeholderModel;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;

public class SoftwareSystem
{
	private @Getter @Setter String name;
	private @Getter	DataModel dataModel;
	private @Getter TransactionModel transactionModel;
	private @Getter StakeholderModel stakeholderModel;
	
	public SoftwareSystem()
	{
		this.name = "";
		this.dataModel = new DataModel();
		this.transactionModel = new TransactionModel();
		this.stakeholderModel = new StakeholderModel();
	}

//	public void clear()
//	{
//		clearUnusedFields();
//		clearUnusedRecordTypes();
//	}

	/**
	 * Removes all unused record types from the model
	 */
//	private void clearUnusedRecordTypes()
//	{
//		for (int i = dataModel.countDataFunctions()-1; i >= 0; i--)
//		{
//			DataFunction dataModelElement = dataModel.getDataFunctionIndex(i);
//			
//			for (int j = dataModelElement.countRecordTypes()-1; j >= 0; j--)
//			{
//				RecordType ret = dataModelElement.getRecordTypeIndex(j);
//				
//				if (ret.countDataElements() == 0)
//					dataModelElement.removeRecordType(j);
//			}
//			
//			if (dataModelElement.countRecordTypes() == 0)
//				dataModel.removeDataFunction(i);
//		}
//	}

	/**
	 * Removes all unused fields from record types in the model
	 */
//	private void clearUnusedFields()
//	{
//		List<DataElement> usedFields = new ArrayList<DataElement>();
//		
//		for (int i = transactionModel.countTransactionFunctions()-1; i >= 0; i--)
//		{
//			TransactionFunction transaction = transactionModel.getTransactionFunctionIndex(i);
//			
//			for (int j = transaction.countFileReferences()-1; j >= 0; j--)
//			{
//				FileReference fileReference = transaction.getFileReferenceIndex(j);
//				
//				if (fileReference.isUseAllFields())
//				{
//					for (DataElement field : fileReference.getReferencedRecordType().getDataElements())
//						usedFields.add(field);
//				} 
//				else
//				{
//					for (FileReferenceField field : fileReference.getFields())
//						usedFields.add(field.getField());
//				}
//			}
//		}
//		
//		for (DataFunction dataModelElement : dataModel.getDataFunctions())
//		{
//			for (RecordType recordType : dataModelElement.getRecordTypes())
//			{
//				for (int i = recordType.countDataElements()-1; i >= 0; i--)
//				{
//					DataElement dataElement = recordType.getDataElementIndex(i);
//					
//					if (!usedFields.contains(dataElement))
//						recordType.removeDataElement(i);
//				}
//			}
//		}
//	}
}