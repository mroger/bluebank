package br.com.bluebank.model.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionJson {

	private Integer accountNumberFrom;
	private Integer accountAgencyFrom;
	private Integer accountNumberTo;
	private Integer accountAgencyTo;
	private BigDecimal amount;
	private String description;
	
	@JsonCreator
	protected TransactionJson(
			@JsonProperty("accountNumberFrom") Integer accountNumberFrom, 
			@JsonProperty("accountAgencyFrom") Integer accountAgencyFrom, 
			@JsonProperty("accountNumberTo") Integer accountNumberTo,
			@JsonProperty("accountAgencyTo") Integer accountAgencyTo, 
			@JsonProperty("amount") BigDecimal amount, 
			@JsonProperty("description") String description) {
		super();
		this.accountNumberFrom = accountNumberFrom;
		this.accountAgencyFrom = accountAgencyFrom;
		this.accountNumberTo = accountNumberTo;
		this.accountAgencyTo = accountAgencyTo;
		this.amount = amount;
		this.description = description;
	}

	public Integer getAccountNumberFrom() {
		return accountNumberFrom;
	}

	public Integer getAccountAgencyFrom() {
		return accountAgencyFrom;
	}

	public Integer getAccountNumberTo() {
		return accountNumberTo;
	}

	public Integer getAccountAgencyTo() {
		return accountAgencyTo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Transaction [accountNumberFrom=" + accountNumberFrom + ", accountAgencyFrom=" + accountAgencyFrom
				+ ", accountNumberTo=" + accountNumberTo + ", accountAgencyTo=" + accountAgencyTo + ", amount=" + amount
				+ ", description=" + description + "]";
	}
	
	
}
