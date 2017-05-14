package br.com.bluebank.service;

import java.math.BigDecimal;
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
import br.com.bluebank.model.AccountHolder;
import br.com.bluebank.model.AccountHolderId;
import br.com.bluebank.model.AccountId;
import br.com.bluebank.model.Transaction;
import br.com.bluebank.model.json.AccountJson;
import br.com.bluebank.model.json.TransactionJson;
import br.com.bluebank.repository.AccountHolderRepository;
import br.com.bluebank.repository.AccountRepository;
import br.com.bluebank.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger LOG  = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;

	@Transactional
	@Override
	public AccountJson transfer(TransactionJson transactionJson) {
		LOG.debug("Processing transfer {}", transactionJson);
		
		AccountId accountIdFrom = new AccountId(transactionJson.getAccountNumberFrom(), transactionJson.getAccountAgencyFrom());
		Account accountFrom = accountRepository.findOne(accountIdFrom);
		LOG.debug("Account: {}", accountFrom);
		
		if (accountFrom == null) {
			throw new AccountNotFoundException("Origin account not found");
		}
		
		AccountId accountIdTo = new AccountId(transactionJson.getAccountNumberTo(), transactionJson.getAccountAgencyTo());
		Account accountTo = accountRepository.findOne(accountIdTo);
		LOG.debug("Account: {}", accountTo);
		
		if (accountTo == null) {
			throw new AccountNotFoundException("Destination account not found");
		}
		
		if (accountFrom.equals(accountTo)) {
			throw new EqualAccountsException("Origin and destination accounts are the same");
		}
		
		if (accountFrom.getBalance().compareTo(transactionJson.getAmount()) < 0) {
			throw new AccountNotEnoughFundsException("Origin account has insufficient funds to complete this transaction");
		}
		
		accountFrom.setBalance(accountFrom.getBalance().subtract(transactionJson.getAmount()));
		Account accountFromPersisted = accountRepository.save(accountFrom);
		
		LOG.debug("Account: {}", accountFromPersisted);
		
		if (transactionJson.getAmount().equals(new BigDecimal("100.0"))) {
			throw new RuntimeException();
		}
		
		accountTo.setBalance(accountTo.getBalance().add(transactionJson.getAmount()));
		Account accountToPersisted = accountRepository.save(accountTo);
		
		LOG.debug("Account: {}", accountToPersisted);
		
		Transaction transaction = new Transaction(
				accountFrom, accountTo, transactionJson.getAmount(), LocalDateTime.now(), transactionJson.getDescription());
		Transaction transactionPersisted = transactionRepository.save(transaction);
		
		LOG.debug("Transaction: {}", transactionPersisted);
		
		return new AccountJson(transactionJson.getAccountNumberFrom(), transactionJson.getAccountAgencyFrom(), accountFromPersisted.getBalance());
	}

}
