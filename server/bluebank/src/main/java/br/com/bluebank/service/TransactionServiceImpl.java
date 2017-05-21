package br.com.bluebank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluebank.model.Account;
import br.com.bluebank.model.Transaction;
import br.com.bluebank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	/*
	 * (non-Javadoc)
	 * @see br.com.bluebank.service.TransactionService#getTransactionsByAccountId(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Transaction> getTransactionsByAccount(final Integer accountAgency, final Integer accountNumber) {
		
		Account account = new Account(accountNumber, accountAgency);
		return transactionRepository.findByAccount(account);
	}

}
