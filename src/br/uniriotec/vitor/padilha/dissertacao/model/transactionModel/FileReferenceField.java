package br.uniriotec.vitor.padilha.dissertacao.model.transactionModel;

import lombok.Getter;
import br.uniriotec.vitor.padilha.dissertacao.model.dataModel.DataElement;

/**
 * Class that represents a field in a file referenced by a transaction
 * 
 * @author Marcio
 */
public class FileReferenceField
{
	private @Getter FileReference fileReference;
	private @Getter DataElement field;
	
	/**
	 * Initializes the field reference
	 */
	public FileReferenceField(FileReference fileReference, DataElement field)
	{
		this.fileReference = fileReference;
		this.field = field;
	}
}