package br.com.bluebank.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.exception.AccountNotEnoughFundsException;
import br.com.bluebank.exception.AccountNotFoundException;
import br.com.bluebank.exception.EqualAccountsException;
import br.com.bluebank.model.Account;
import br.com.bluebank.model.AccountId;
import br.com.bluebank.model.Transaction;
import br.com.bluebank.model.json.TransactionJson;
import br.com.bluebank.repository.AccountRepository;
import br.com.bluebank.repository.TransactionRepository;

/**
 * Service implementation for accounts
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger LOG  = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	/*
	 * (non-Javadoc)
	 * @see br.com.bluebank.service.AccountService#transfer(br.com.bluebank.model.json.TransactionJson)
	 */
	@Transactional
	@Override
	public Account transfer(final TransactionJson transactionJson) {
		LOG.debug("Processing transfer {}", transactionJson);
		
		Account accountOrigin = accountRepository.findOne(getAccountIdFrom(transactionJson));
		LOG.debug("Account: {}", accountOrigin);
		
		Account accountDestination = accountRepository.findOne(getAccountIdTo(transactionJson));
		LOG.debug("Account: {}", accountDestination);
		
		validateAccounts(transactionJson, accountOrigin, accountDestination);
		
		accountOrigin.setBalance(accountOrigin.getBalance().subtract(transactionJson.getAmount()));
		Account accountOriginPersisted = accountRepository.save(accountOrigin);
		
		LOG.debug("Account: {}", accountOriginPersisted);
		
		accountDestination.setBalance(accountDestination.getBalance().add(transactionJson.getAmount()));
		Account accountToPersisted = accountRepository.save(accountDestination);
		
		LOG.debug("Account: {}", accountToPersisted);
		
		Transaction transaction = new Transaction(
				accountOrigin, accountDestination, transactionJson.getAmount(), LocalDateTime.now(), transactionJson.getDescription());
		Transaction transactionPersisted = transactionRepository.save(transaction);
		
		LOG.debug("Transaction: {}", transactionPersisted);
		
		return accountOriginPersisted;
	}

	private void validateAccounts(final TransactionJson transactionJson, final Account accountFrom, final Account accountTo) {
		if (accountFrom == null) {
			throw new AccountNotFoundException("Origin account not found");
		}
		
		if (accountTo == null) {
			throw new AccountNotFoundException("Destination account not found");
		}
		
		if (accountFrom.equals(accountTo)) {
			throw new EqualAccountsException("Origin and destination accounts are the same");
		}
		
		if (accountFrom.getBalance().compareTo(transactionJson.getAmount()) < 0) {
			throw new AccountNotEnoughFundsException("Origin account has insufficient funds to complete this transaction");
		}
	}

	private AccountId getAccountIdFrom(final TransactionJson transactionJson) {
		return new AccountId(transactionJson.getAccountNumberFrom(), transactionJson.getAccountAgencyFrom());
	}

	private AccountId getAccountIdTo(final TransactionJson transactionJson) {
		return new AccountId(transactionJson.getAccountNumberTo(), transactionJson.getAccountAgencyTo());
	}

}
