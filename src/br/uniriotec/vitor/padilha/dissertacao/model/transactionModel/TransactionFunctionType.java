package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import lombok.Getter;

/**
 * Enumeration for the types of transaction function
 * 
 * @author marcio.barros
 */
public enum TransactionFunctionType
{
	EO("EO"),
	EI("EI"),
	EQ("EQ");
	
	private @Getter String code;
	
	private TransactionFunctionType(String code)
	{
		this.code = code;
	}
	
	public static TransactionFunctionType get(String code)
	{
		for (TransactionFunctionType type : values())
			if (type.getCode().compareTo(code) == 0)
				return type;
		
		return null;
	}
}