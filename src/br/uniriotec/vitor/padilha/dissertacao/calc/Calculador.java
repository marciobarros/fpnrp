package br.uniriotec.vitor.padilha.dissertacao.calc;

import br.uniriotec.vitor.padilha.dissertacao.engine.Complexity;
import br.uniriotec.vitor.padilha.dissertacao.model.SoftwareSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunction;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.Interest;
import br.uniriotec.vitor.padilha.dissertacao.model.stakeholderModel.Stakeholder;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReference;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.FileReferenceField;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionDependency;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

//Limitacoes
//- limitar um RET em 32 campos
//
//Preparador de calculo
//- calcula FP de cada transacaoo - ok
//- transacao tem field mask por RET
//- DMStatus tem field mask por RET
//
//No calculo
//- cria DMStatus zerado
//- percorre transacaes ligadas
//-- bitwise OR dos RET com DMS
//-- soma FP das transacoes ligadas
//-- cplx = #trans * #med FTR
//- percorre DMElements
//-- conta campos e RET
//-- cplx = #DME * #med RET

public class Calculador
{
	private SoftwareSystem system;
	private int[] transactionFunctionPoints;
	private int[] transactionSatisfaction;
	
	public void prepareSoftware(SoftwareSystem system)
	{
		this.system = system;
		this.transactionFunctionPoints = calculateTransactionFunctionPoints();
		this.transactionSatisfaction = calculateTransactionSatisfaction();
	}
	
	private int[] calculateTransactionFunctionPoints()
	{
		int count = system.getTransactionModel().countTransactionFunctions();
		int[] functionPoints = new int[count];
		
		for (int i = 0; i < count; i++)
		{
			TransactionFunction transaction = system.getTransactionModel().getTransactionFunctionIndex(i);
			functionPoints[i] = transaction.calculateFunctionPoints();
		}
		
		return functionPoints;
	}
	
	private int[] calculateTransactionSatisfaction()
	{
		int count = system.getTransactionModel().countTransactionFunctions();
		int[] satisfaction = new int[count];
		
		for (Stakeholder stakeholder : system.getStakeholderModel().getStakeholders())
		{
			for (Interest interest : stakeholder.getInterests())
			{
				int index = system.getTransactionModel().getTransactionIndex(interest.getTransaction());
				satisfaction[index] += stakeholder.getWeight() * interest.getValue();
			}
		}
		
		return satisfaction;
	}
	
	public int process(boolean[] selectedTransactions)
	{
		selectedTransactions = expandSelectionDueDependencies(selectedTransactions);
		
		DataModelStatus dms = new DataModelStatus(system.getDataModel());
		
		for (int i = 0; i < system.getTransactionModel().countTransactionFunctions(); i++)
		{
			if (selectedTransactions[i])
			{
				TransactionFunction transaction = system.getTransactionModel().getTransactionFunctionIndex(i);
				
				for (FileReference reference : transaction.getFileReferences())
				{
					if (reference.isUseAllFields())
					{
						for (DataElement dataElement : reference.getReferencedRecordType().getDataElements())
						{
							if (!dataElement.isPrimaryKey() || dataElement.isSemanticMeaning())
								dms.useDataElement(dataElement);
						}
					}
					else
					{
						for (FileReferenceField field : reference.getFields())
						{
							DataElement dataElement = field.getField();
							
							if (!dataElement.isPrimaryKey() || dataElement.isSemanticMeaning())
								dms.useDataElement(dataElement);
						}
					}
				}
			}
		}
		
		int fp = 0;
		
		for (int i = 0; i < system.getTransactionModel().countTransactionFunctions(); i++)
		{
			if (selectedTransactions[i])
			{
				fp += transactionFunctionPoints[i];
			}
		}

		for (int i = 0; i < system.getDataModel().countDataFunctions(); i++)
		{
			DataFunction df = system.getDataModel().getDataFunctionIndex(i);
			DataFunctionStatus dfs = dms.getDataFunctionStatus(df);
			int retCount = dfs.countRecordTypes();
			int detCount = dfs.countDataElements();
			
			if (detCount > 0)
				fp += Complexity.calculateDataFunctionComplexity(retCount, detCount).calculateFunctionPoints(df.getType());
		}

		return fp;
	}
	
	public int calculateSatisfaction(boolean[] selectedTransactions)
	{
		selectedTransactions = expandSelectionDueDependencies(selectedTransactions);
		int count = system.getTransactionModel().countTransactionFunctions();
		int result = 0;
		
		for (int i = 0; i < count; i++)
			if (selectedTransactions[i])
				result += transactionSatisfaction[i];
		
		return result;
	}
	
	private boolean[] expandSelectionDueDependencies(boolean[] selectedTransactions)
	{
		int count = system.getTransactionModel().countTransactionFunctions();

		for (int i = 0; i < count; i++)
		{
			if (selectedTransactions[i])
			{
				TransactionFunction transaction = system.getTransactionModel().getTransactionFunctionIndex(i);
				selectedTransactions = expandSelectionDueDependencies(transaction, selectedTransactions);
			}
		}
		
		return selectedTransactions;
	}
	
	private boolean[] expandSelectionDueDependencies(TransactionFunction transaction, boolean[] selectedTransactions)
	{
		for (TransactionDependency dependency : transaction.getDependencies())
		{
			TransactionFunction referencedTransaction = dependency.getReferencedTransactionFunction();
			int index = system.getTransactionModel().getTransactionIndex(referencedTransaction);
			
			if (!selectedTransactions[index])
			{
				selectedTransactions[index] = true;
				selectedTransactions = expandSelectionDueDependencies(referencedTransaction, selectedTransactions);
			}
		}
		
		return selectedTransactions;
	}


	public boolean[] allTransactions()
	{
		int count = system.getTransactionModel().countTransactionFunctions();
		boolean[] result = new boolean[count];

		for (int i = 0; i < count; i++)
			result[i] = true;
		
		return result;
	}

	public boolean[] noTransactions()
	{
		int count = system.getTransactionModel().countTransactionFunctions();
		boolean[] result = new boolean[count];

		for (int i = 0; i < count; i++)
			result[i] = false;
		
		return result;
	}

	public boolean[] addTransactions(boolean[] selectedTransactions, int index)
	{
		selectedTransactions[index] = true;
		return selectedTransactions;
	}
}