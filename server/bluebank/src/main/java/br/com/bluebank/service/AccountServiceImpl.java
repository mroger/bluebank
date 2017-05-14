package br.com.bluebank.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.bluebank.model.json.AccountJson;
import br.com.bluebank.model.json.TransactionJson;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger LOG  = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public AccountJson transfer(TransactionJson transfer) {
		LOG.debug("Processing transfer {}", transfer);
		
		return new AccountJson(transfer.getAccountNumberFrom(), transfer.getAccountAgencyFrom(), BigDecimal.ZERO);
	}

}
