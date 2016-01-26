package br.uniriotec.vitor.padilha.dissertacao.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModel;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataModelElementType;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.RecordType;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests.Interest;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReferenceField;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionModel;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionType;

public class FunctionPointCalculator
{
	/**
	 * Calculates the number of function points for a system
	 */
	public int calculate(FunctionPointSystem functionPointSystem, int releaseNumber)
	{
		int fp = calculateDataModel(functionPointSystem.getDataModel(), releaseNumber);
		fp += calculateTransactionModel(functionPointSystem.getTransactionModel(), releaseNumber);
		return fp;
	}

	/**
	 * Calculates the number of function points for a data model
	 */
	private int calculateDataModel(DataModel dataModel, int releaseNumber)
	{
		int functionPoints = 0;

		for (DataModelElement dataModelElement : dataModel.getElements())
			functionPoints += calculateDataModelElement(dataModelElement, releaseNumber);

		return functionPoints;
	}

	public int calculateDataModelElement(DataModelElement dataModelElement, int releaseNumber)
	{
		int detCount = 0;
		int retCount = 0;
		Set<String> dets = new HashSet<String>();
		Map<String, List<String>> rets = new HashMap<String, List<String>>();
		rets.put("", new ArrayList<String>());
		Set<String> retsExtendidos = new HashSet<String>();
		
		for (RecordType ret : dataModelElement.getRecordTypes())
		{
			retCount++;
			
			if (ret.getExtendsRet() != null)
			{
				if (retsExtendidos.contains(ret.getExtendsRet()))
				{
					retCount--;
				} 
				else
				{
					retsExtendidos.add(ret.getExtendsRet());
					rets.put(ret.getExtendsRet(), new ArrayList<String>());
				}
				
				rets.get(ret.getExtendsRet()).add(ret.getName());
			} 
			else
			{
				rets.get("").add(ret.getName());
			}

			for (DataElement det : ret.getDataElements())
			{
				det.setFlagCanBeDetInTransation(true);

				if (!det.isHasSemanticMeaning())
					continue;

				detCount++;

				if (det.getRetRef() != null)
				{
					if (!det.getRetRef().getParent().getName().equals(ret.getParent().getName()) && det.isPrimaryKey())
					{
						det.setFlagCanBeDetInTransation(false);
						detCount--;
						continue;
					}
				}

				dets.add(det.getParent().getName() + "." + det.getName());
			}
		}

		List<String[]> retsNorm = new ArrayList<String[]>();
		
		for (String chave : rets.keySet())
		{
			if (chave.equals(""))
			{
				for (String ret : rets.get(chave))
				{
					String[] retGroup = new String[1];
					retGroup[0] = ret;
					retsNorm.add(retGroup);
				}
			} 
			else
			{
				String[] retGroup = new String[rets.get(chave).size()];
				int cont = 0;
		
				for (String ret : rets.get(chave))
				{
					retGroup[cont] = ret;
					cont++;
				}
				
				retsNorm.add(retGroup);
			}
		}

		Complexity complexity = calculateDataModelElementComplexity(retCount, detCount);
		return calculateFunctionPoints(complexity, dataModelElement.getType());
	}

	/**
	 * Calculates the number of function points for a transaction model
	 */
	private int calculateTransactionModel(TransactionModel transactionModel, int releaseNumber)
	{
		int functionPoints = 0;
		
		for (Transaction transaction : transactionModel.getTransactions())
			if (transaction.getReleaseImplementation() == 0)
				functionPoints += calculateTransactionValue(transaction, releaseNumber);

		return functionPoints;
	}

	public int calculateTransactionValue(Transaction transaction, int releaseNumber)
	{
		 int ftrCount = 0;
		 int detCount = 0;

		Set<String> referencedFiles = new HashSet<String>();
		List<String> fields = new ArrayList<String>();
		Map<String, String> refFields = new HashMap<String, String>();
		
		for (FileReference ftr : transaction.getFileReferences())
		{
			if (!referencedFiles.contains(ftr.getDataModelElement()))
			{
				referencedFiles.add(ftr.getDataModelElement());
				ftrCount++;
			}

			if (!ftr.isUseAllDets())
			{
				for (FileReferenceField field : ftr.getFields())
				{
					if (field.getField() != null && field.getField().canBeDetForTransaction())
					{
						String fullName = field.getParent().getName() + "." + field.getField().getName();
						
						if (!fields.contains(fullName))
						{
							fields.add(fullName);
							detCount++;
						}
					}
				}
			} 
			else
			{
				for (DataElement field : ftr.getRetRef().getDataElements())
				{
					if (field.canBeDetForTransaction())
					{
						String fieldName = "";
						
						if (field.getRetRef() != null)
						{
							if (!refFields.containsKey(field.getRetRef().getParent().getName()))
							{
								refFields.put(field.getRetRef().getParent().getName(), field.getParent().getName() + "." + field.getName() + "(" + field.getRetRef().getParent().getName() + ")");
							}
						} 
						else
						{
							fieldName = field.getParent().getName() + "." + field.getName();
						
							if (!fields.contains(fieldName))
							{
								fields.add(fieldName);
								detCount++;
							}
						}
					}
				}
			}
		}
		
		for (String ftr : refFields.keySet())
		{
			if (!referencedFiles.contains(ftr))
			{
				referencedFiles.add(ftr);
				detCount++;
				ftrCount++;
			}
		}
		
		if (transaction.isErrorMsg())
			detCount++;
		
		detCount += transaction.getExtraDET();
		
		Complexity complexity = calculateTransactionComplexity(ftrCount, detCount, transaction.getType());
		return calculateFunctionPoints(complexity, transaction.getType());
	}

	/**
	 * Calculates the complexity of a data model element
	 */
	private Complexity calculateDataModelElementComplexity(int ret, int det)
	{
		if ((ret >= 6 && det >= 20) || (ret <= 5 && ret >= 2 && det >= 51))
			return Complexity.HIGH;

		if (ret >= 6 || (ret <= 5 && ret >= 2 && det >= 20 && det <= 50) || (ret == 1 && det >= 51))
			return Complexity.MEDIUM;
		
		return Complexity.LOW;
	}

	/**
	 * Calculates the number of function points assigned to a data model element
	 */
	private int calculateFunctionPoints(Complexity complexity, DataModelElementType type)
	{
		if (type == DataModelElementType.ILF)
		{
			if (complexity == Complexity.LOW)
				return 7;
			
			if (complexity == Complexity.MEDIUM)
				return 10;
			
			return 15;
		}
		else
		{
			if (complexity == Complexity.LOW)
				return 5;
			
			if (complexity == Complexity.MEDIUM)
				return 7;
			
			return 10;
		}
	}

	/**
	 * Calculates the complexity of a transaction
	 */
	private Complexity calculateTransactionComplexity(int ftrs, int dets, TransactionType type)
	{
		if (type == TransactionType.EO || type == TransactionType.EQ)
		{
			if ((ftrs >= 4 && dets >= 6) || (ftrs >= 2 && ftrs <= 3 && dets >= 20))
				return Complexity.HIGH;

			if ((ftrs >= 4 && dets <= 5) || (ftrs >= 2 && ftrs <= 3 && dets >= 6 && dets <= 19) || (ftrs <= 1 && dets >= 20))
				return Complexity.MEDIUM;
			
			return Complexity.LOW;
		}
		else
		{
			if ((ftrs >= 3 && dets >= 5) || (ftrs == 2 && dets >= 16))
				return Complexity.HIGH;
			
			if ((ftrs >= 3 && dets <= 4) || (ftrs == 2 && dets >= 5 && dets <= 15) || (ftrs <= 1 && dets >= 16))
				return Complexity.MEDIUM;
			
			return Complexity.LOW;
		}
	}

	/**
	 * Calculates the number of function points assigned to a transaction
	 */
	private int calculateFunctionPoints(Complexity complexity, TransactionType type)
	{
		if (type == TransactionType.EI || type == TransactionType.EQ)
		{
			if (complexity == Complexity.LOW)
				return 3;
			
			if (complexity == Complexity.MEDIUM)
				return 4;
			
			return 6;
		}
		else
		{
			if (complexity == Complexity.LOW)
				return 4;
			
			if (complexity == Complexity.MEDIUM)
				return 5;
			
			return 7;
		}
	}

	/**
	 * Calculates stakeholder's satisfaction for a system
	 */
	public long calculateSatisfaction(FunctionPointSystem system)
	{
		long total = 0L;

		for (Interest interest : system.getStakeholderInterests().getInterests())
		{
			for (Transaction transaction : system.getTransactionModel().getTransactions())
			{
				if (transaction.getName().compareTo(interest.getTransaction().getName()) == 0)
					total += interest.getInterest() * interest.getStakeholder().getWeight();
			}
		}
		
		return total;
	}

	/**
	 * Calculate stakeholder's gain from a baseline
	 */
	public double calculateUserSatisfactionPercent(FunctionPointSystem system, long baseline)
	{
		return (calculateSatisfaction(system) * 100.0) / baseline;
	}
}