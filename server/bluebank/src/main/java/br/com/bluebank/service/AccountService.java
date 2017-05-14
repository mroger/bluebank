package br.com.bluebank.service;

import br.com.bluebank.model.json.AccountJson;
import br.com.bluebank.model.json.TransactionJson;

public interface AccountService {
	
	AccountJson transfer(TransactionJson transaction);

}