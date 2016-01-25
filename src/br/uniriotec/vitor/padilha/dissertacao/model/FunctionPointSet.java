package br.uniriotec.vitor.padilha.dissertacao.model;

import java.util.HashSet;
import java.util.Set;

import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;

public class FunctionPointSet
{
	private Set<Transaction> transactions;

	public FunctionPointSet()
	{
		this.transactions = new HashSet<Transaction>();
	}

	public Set<Transaction> getTransactions()
	{
		return transactions;
	}
}