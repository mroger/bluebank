package br.com.bluebank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.model.Account;
import br.com.bluebank.model.json.AccountJson;
import br.com.bluebank.model.json.TransactionJson;
import br.com.bluebank.service.AccountService;
import io.swagger.annotations.ApiOperation;

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
	 * Transfers funds from one account to another.
	 * Validation to guarantee consistency are applied.
	 * 
	 * @param transaction
	 * @return origin and destination accounts with their new balances
	 */
	@ApiOperation(
            value = "Transfer funds from one account to the other",
            nickname = "transfer")
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public AccountJson transfer(@Valid @RequestBody TransactionJson transaction) {
		
		Account account = accountService.transfer(transaction);
		
		return AccountJson.fromModel(account);
	}
	
}
