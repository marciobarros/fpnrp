package br.uniriotec.vitor.padilha.dissertacao.model.dataModel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class RET
{
	/**
	 * 
	 */
	private List<DET> dets;

	/**
	 * 
	 */
	private @Getter @Setter String name;

	/**
	 * 
	 */
	private @Getter @Setter String extendsRet;

	/**
	 * Returns an iterator for the data elements
	 */
	public Iterable<DET> getDets()
	{
		return dets;
	}

	/**
	 * 
	 */
	public boolean validate() throws Exception
	{
		if (this.getName() == null || this.getName().equals(""))
			throw new Exception("Nome obrigatório");

		for (DET field : getDets())
			if (!field.validate())
				return false;

		return true;
	}

	/**
	 * 
	 */
	public void charge()
	{
		for (DET field : getDets())
			field.charge();
	}
}