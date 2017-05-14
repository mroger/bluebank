package br.com.bluebank.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public AccountJson transfer(TransactionJson transfer) {
		LOG.debug("Processing transfer {}", transfer);
		
		AccountId accountId = new AccountId();
		accountId.setNumber(1);
		accountId.setAgency(1);
		Account account = accountRepository.findOne(accountId);
		LOG.debug("Account: {}", account);
		
		Transaction transaction = transactionRepository.findOne(1L);
		LOG.debug("Transaction: {}", transaction);
		
		AccountHolderId accountHolderId = new AccountHolderId();
		accountHolderId.setAccountNumber(1);
		accountHolderId.setAccountAgency(1);
		accountHolderId.setCpf("51271204452");
		accountHolderId.setId(1L);
		AccountHolder accountHolder = accountHolderRepository.findOne(accountHolderId);
		LOG.debug("AccountHolder: {}", accountHolder);
		
		return new AccountJson(transfer.getAccountNumberFrom(), transfer.getAccountAgencyFrom(), BigDecimal.ZERO);
	}

}
