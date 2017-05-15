package br.com.bluebank.service;

import br.com.bluebank.model.json.AccountJson;
import br.com.bluebank.model.json.TransactionJson;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Service for account
 */
public interface AccountService {
	
	/**
	 * Method to transfer funds from an origin account to a destination
	 * account. Implements validation to guarantee consistency.
	 * 
	 * @param transaction
	 * @return Origin account with its new  balance  
	 */
	AccountJson transfer(TransactionJson transaction);

}