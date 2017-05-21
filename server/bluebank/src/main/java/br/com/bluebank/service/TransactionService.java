package br.com.bluebank.service;

import java.util.List;

import br.com.bluebank.model.Transaction;

public interface TransactionService {

	/**
	 * Returns a list of transactions by account id (accountAgency and accountNumber).
	 * 
	 * @param accountAgency
	 * @param accountNumber
	 * @return List of transactions
	 */
	List<Transaction> getTransactionsByAccount(Integer accountAgency, Integer accountNumber);

}
