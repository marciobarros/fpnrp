package br.uniriotec.vitor.padilha.dissertacao;

import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;

public interface ElementValidator {

	public boolean validate() throws ElementException;
}
