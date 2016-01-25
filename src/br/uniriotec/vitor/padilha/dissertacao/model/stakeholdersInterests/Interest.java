package br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests;

import lombok.Data;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;

/**
 * 
 * @author marcio.barros
 */
public @Data class Interest 
{
	private String stakeholderXML;
	private String transactionXML;
	private Stakeholder stakeholder;
	private Transaction transaction;
	private long interest;
}