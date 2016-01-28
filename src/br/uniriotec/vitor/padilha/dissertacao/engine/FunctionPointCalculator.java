package br.uniriotec.vitor.padilha.dissertacao.engine;

import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.Interest;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.Stakeholder;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;

public class FunctionPointCalculator
{
	/**
	 * Calculates the number of function points for a system
	 */
	public int calculate(SoftwareSystem system)
	{
		return calculateDataModel(system.getDataModel()) + calculateTransactionModel(system.getTransactionModel());
	}

	/**
	 * Calculates the number of function points for a data model
	 */
	private int calculateDataModel(DataModel dataModel)
	{
		int functionPoints = 0;

		for (DataFunction dataFunction : dataModel.getDataFunctions())
		{
			Complexity complexity = calculateDataFunction(dataFunction);
			functionPoints += complexity.calculateFunctionPoints(dataFunction.getType());
		}
		
		return functionPoints;
	}

	/**
	 * Calculates the number of function points for a transaction model
	 */
	private int calculateTransactionModel(TransactionModel transactionModel)
	{
		int functionPoints = 0;
		
		for (TransactionFunction transactionFunction : transactionModel.getTransactionFunctions())
		{
			Complexity complexity = calculateTransactionValue(transactionFunction);
			functionPoints += complexity.calculateFunctionPoints(transactionFunction.getType());
		}

		return functionPoints;
	}

	/**
	 * Calculates the number of function points for a data function
	 */
	public Complexity calculateDataFunction(DataFunction dataFunction)
	{
//		int detCount = 0;
//		int retCount = 0;
//		Set<String> dets = new HashSet<String>();
//		Map<String, List<String>> rets = new HashMap<String, List<String>>();
//		rets.put("", new ArrayList<String>());
//		
//		for (RecordType ret : dataModelElement.getRecordTypes())
//		{
//			retCount++;
//			rets.get("").add(ret.getName());
//
//			for (DataElement det : ret.getDataElements())
//			{
//				det.setFlagCanBeDetInTransation(true);
//
//				if (!det.isSemanticMeaning())
//					continue;
//
//				detCount++;
//
//				if (det.getReferencedRecordType() != null)
//				{
//					if (det.getReferencedRecordType().getDataFunction() != ret.getDataFunction() && det.isPrimaryKey())
//					{
//						det.setFlagCanBeDetInTransation(false);
//						detCount--;
//						continue;
//					}
//				}
//
//				dets.add(det.getRecordType().getName() + "." + det.getName());
//			}
//		}
//
//		List<String[]> retsNorm = new ArrayList<String[]>();
//		
//		for (String chave : rets.keySet())
//		{
//			if (chave.equals(""))
//			{
//				for (String ret : rets.get(chave))
//				{
//					String[] retGroup = new String[1];
//					retGroup[0] = ret;
//					retsNorm.add(retGroup);
//				}
//			} 
//			else
//			{
//				String[] retGroup = new String[rets.get(chave).size()];
//				int cont = 0;
//		
//				for (String ret : rets.get(chave))
//				{
//					retGroup[cont] = ret;
//					cont++;
//				}
//				
//				retsNorm.add(retGroup);
//			}
//		}
		int retCount = dataFunction.countRecordTypes();
		int detCount = dataFunction.countDataElements();
		return Complexity.calculateDataFunctionComplexity(retCount, detCount);
	}

	public Complexity calculateTransactionValue(TransactionFunction transaction)
	{
//		 int ftrCount = 0;
//		 int detCount = 0;
//
//		Set<DataFunction> referencedFiles = new HashSet<DataFunction>();
//		List<String> fields = new ArrayList<String>();
//		Map<String, String> refFields = new HashMap<String, String>();
//		
//		for (FileReference ftr : transaction.getFileReferences())
//		{
//			if (!referencedFiles.contains(ftr.getReferencedRecordType().getDataFunction()))
//			{
//				referencedFiles.add(ftr.getReferencedRecordType().getDataFunction());
//				ftrCount++;
//			}
//
//			if (!ftr.isUseAllFields())
//			{
//				for (FileReferenceField field : ftr.getFields())
//				{
//					if (field.getField() != null && field.getField().canBeDetForTransaction())
//					{
//						String fullName = field.getFileReference().getReferencedRecordType().getName() + "." + field.getField().getName();
//						
//						if (!fields.contains(fullName))
//						{
//							fields.add(fullName);
//							detCount++;
//						}
//					}
//				}
//			} 
//			else
//			{
//				for (DataElement field : ftr.getReferencedRecordType().getDataElements())
//				{
//					if (field.canBeDetForTransaction())
//					{
//						String fieldName = "";
//						
//						if (field.getRetRef() != null)
//						{
//							if (!refFields.containsKey(field.getRetRef().getParent().getName()))
//							{
//								refFields.put(field.getRetRef().getParent().getName(), field.getParent().getName() + "." + field.getName() + "(" + field.getRetRef().getParent().getName() + ")");
//							}
//						} 
//						else
//						{
//							fieldName = field.getParent().getName() + "." + field.getName();
//						
//							if (!fields.contains(fieldName))
//							{
//								fields.add(fieldName);
//								detCount++;
//							}
//						}
//					}
//				}
//			}
//		}
//		
//		for (String ftr : refFields.keySet())
//		{
//			if (!referencedFiles.contains(ftr))
//			{
//				referencedFiles.add(ftr);
//				detCount++;
//				ftrCount++;
//			}
//		}
//		
//		if (transaction.isErrorMsg())
//			detCount++;
//		
//		detCount += transaction.getExtraDET();
		
		int ftrCount = transaction.countReferencedDataFunctions();
		int detCount = transaction.countDataElements();
		return Complexity.calculateTransactionComplexity(ftrCount, detCount, transaction.getType());
	}

	/**
	 * Calculates stakeholder's satisfaction for a system
	 */
	public double calculateSatisfaction(SoftwareSystem system)
	{
		double total = 0.0;

		for (Stakeholder stakeholder : system.getStakeholderModel().getStakeholders())
		{
			for (Interest interest : stakeholder.getInterests())
			{
				for (TransactionFunction transaction : system.getTransactionModel().getTransactionFunctions())
				{
					if (transaction == interest.getTransaction())
						total += interest.getValue() * stakeholder.getWeight();
				}
			}
		}
		
		return total;
	}

	/**
	 * Calculate stakeholder's gain from a baseline
	 */
	public double calculateUserSatisfactionPercent(SoftwareSystem system, long baseline)
	{
		return (calculateSatisfaction(system) * 100.0) / baseline;
	}
}