package br.com.bluebank.model.json;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionJson {

	@NotNull
	private Integer accountNumberFrom;
	@NotNull
	private Integer accountAgencyFrom;
	@NotNull
	private Integer accountNumberTo;
	@NotNull
	private Integer accountAgencyTo;
	@NotNull
	private BigDecimal amount;
	private String description;
	
	@JsonCreator
	public TransactionJson(
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
		return "TransactionJson [accountNumberFrom=" + accountNumberFrom + ", accountAgencyFrom=" + accountAgencyFrom
				+ ", accountNumberTo=" + accountNumberTo + ", accountAgencyTo="
				+ accountAgencyTo + ", amount=" + amount + ", description=" + description + "]";
	}
	
	
}
