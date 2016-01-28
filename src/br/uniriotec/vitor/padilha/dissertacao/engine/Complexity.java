package br.uniriotec.vitor.padilha.dissertacao.engine;

import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataFunctionType;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunctionType;

/**
 * 
 * 
 * @author Marcio
 */
public enum Complexity 
{
	LOW,
	MEDIUM,
	HIGH;

	/**
	 * Calculates the complexity of a data function
	 */
	public static Complexity calculateDataFunctionComplexity(int ret, int det)
	{
		if ((ret >= 6 && det >= 20) || (ret >= 2 && ret <= 5 && det >= 51))
			return HIGH;

		if (ret >= 6 || (ret >= 2 && ret <= 5 && det >= 20) || (ret == 1 && det >= 51))
			return MEDIUM;
		
		return LOW;
	}

	/**
	 * Calculates the number of function points assigned to a data model element
	 */
	public int calculateFunctionPoints(DataFunctionType type)
	{
		if (type == DataFunctionType.ILF)
		{
			if (this == LOW)
				return 7;
			
			if (this == MEDIUM)
				return 10;
			
			return 15;
		}
		else
		{
			if (this == Complexity.LOW)
				return 5;
			
			if (this == Complexity.MEDIUM)
				return 7;
			
			return 10;
		}
	}

	/**
	 * Calculates the complexity of a transaction
	 */
	public static Complexity calculateTransactionComplexity(int ftrs, int dets, TransactionFunctionType type)
	{
		if (type == TransactionFunctionType.EO || type == TransactionFunctionType.EQ)
		{
			if ((ftrs >= 4 && dets >= 6) || (ftrs >= 2 && ftrs <= 3 && dets >= 20))
				return HIGH;

			if (ftrs >= 4 || (ftrs >= 2 && ftrs <= 3 && dets >= 6) || (ftrs <= 1 && dets >= 20))
				return MEDIUM;
			
			return LOW;
		}
		else
		{
			if ((ftrs >= 3 && dets >= 5) || (ftrs == 2 && dets >= 16))
				return HIGH;
			
			if (ftrs >= 3 || (ftrs == 2 && dets >= 5 && dets <= 15) || (ftrs <= 1 && dets >= 16))
				return MEDIUM;
			
			return LOW;
		}
	}

	/**
	 * Calculates the number of function points assigned to a transaction
	 */
	public int calculateFunctionPoints(TransactionFunctionType type)
	{
		if (type == TransactionFunctionType.EI || type == TransactionFunctionType.EQ)
		{
			if (this == Complexity.LOW)
				return 3;
			
			if (this == Complexity.MEDIUM)
				return 4;
			
			return 6;
		}
		else
		{
			if (this == Complexity.LOW)
				return 4;
			
			if (this == Complexity.MEDIUM)
				return 5;
			
			return 7;
		}
	}
}