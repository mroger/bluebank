package br.com.bluebank.model.json;

import java.math.BigDecimal;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Account DTO
 */
public class AccountJson {

	private Integer accountNumber;
	private Integer accountAgency;
	private BigDecimal balance;
	
	public AccountJson(Integer accountNumber, Integer accountAgency, BigDecimal balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountAgency = accountAgency;
		this.balance = balance;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public Integer getAccountAgency() {
		return accountAgency;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "AccountJson [accountNumber=" + accountNumber + ", accountAgency=" + accountAgency + ", balance="
				+ balance + "]";
	}
	
}
