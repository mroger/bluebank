package br.com.bluebank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.model.json.AccountJson;
import br.com.bluebank.model.json.TransactionJson;
import br.com.bluebank.service.AccountService;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Accounts controller
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	/**
	 * 
	 * @param transaction
	 * @return origin and destination accounts with their new balances
	 */
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public AccountJson transfer(@Valid @RequestBody TransactionJson transaction) {
		
		return accountService.transfer(transaction);
	}
	
}
