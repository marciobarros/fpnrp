package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.uniriotec.vitor.padilha.dissertacao.model.constants.DataModelElementType;

public abstract class DataModelElement
{
	/**
	 * List of record types for the data model element
	 */
	private List<RET> rets;

	/**
	 * Element name
	 */
	private @Getter @Setter String name;

	/**
	 * Element type
	 */
	private @Getter @Setter DataModelElementType type;

	/**
	 * Value in function points (?)
	 */
	private @Getter @Setter int functionsPointValue = 0;

	/**
	 * Returns an iterator for the record types
	 */
	public Iterable<RET> getRecordTypes()
	{
		return rets;
	}

	/**
	 * Validate the model
	 */
	public boolean validate() throws Exception
	{
		if (this.getName() == null || this.getName().equals(""))
			throw new Exception("Nome obrigatório");

		for (RET ret : getRecordTypes())
			if (!ret.validate())
				return false;
		
		return true;
	}

	/**
	 * Charge the model
	 */
	public void charge()
	{
		for (RET ret : getRecordTypes())
			ret.charge();
	}
}