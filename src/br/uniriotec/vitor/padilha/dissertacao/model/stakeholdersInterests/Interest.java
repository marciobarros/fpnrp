package br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests;

import lombok.Data;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

/**
 * 
 * @author marcio.barros
 */
public @Data class Interest 
{
	private String stakeholderXML;
	private String transactionXML;
	private Stakeholder stakeholder;
	private TransactionFunction transaction;
	private long interest;
}