package br.uniriotec.vitor.padilha.dissertacao.model;

import java.util.HashSet;
import java.util.Set;

import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.TransactionFunction;

public class FunctionPointSet
{
	private Set<TransactionFunction> transactions;

	public FunctionPointSet()
	{
		this.transactions = new HashSet<TransactionFunction>();
	}

	public Set<TransactionFunction> getTransactions()
	{
		return transactions;
	}
}