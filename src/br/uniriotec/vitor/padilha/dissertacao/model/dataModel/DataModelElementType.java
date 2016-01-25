package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import lombok.Getter;

/**
 * Enumeration of the data function types handled by the program
 * 
 * @author marcio.barros
 */
public enum DataModelElementType
{
	EIF("EIF"), 
	ILF("ILF");
	
	private @Getter String code;
	
	private DataModelElementType(String code)
	{
		this.code = code;
	}
	
	public static DataModelElementType get(String code)
	{
		for (DataModelElementType type : values())
			if (type.getCode().compareTo(code) == 0)
				return type;
		
		return null;
	}
}