package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import lombok.Getter;

/**
 * Enumeration of the data function types handled by the program
 * 
 * @author marcio.barros
 */
public enum DataFunctionType
{
	EIF("EIF"), 
	ILF("ILF");
	
	private @Getter String code;
	
	private DataFunctionType(String code)
	{
		this.code = code;
	}
	
	public static DataFunctionType get(String code)
	{
		for (DataFunctionType type : values())
			if (type.getCode().compareTo(code) == 0)
				return type;
		
		return null;
	}
}