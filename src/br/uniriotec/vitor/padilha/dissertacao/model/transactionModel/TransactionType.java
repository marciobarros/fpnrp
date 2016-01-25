package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import lombok.Getter;

/**
 * Enumeration for the types of transaction handled by the program
 * 
 * @author marcio.barros
 */
public enum TransactionType
{
	EO("EO"),
	EI("EI"),
	EQ("EQ");
	
	private @Getter String code;
	
	private TransactionType(String code)
	{
		this.code = code;
	}
	
	public static TransactionType get(String code)
	{
		for (TransactionType type : values())
			if (type.getCode().compareTo(code) == 0)
				return type;
		
		return null;
	}
}