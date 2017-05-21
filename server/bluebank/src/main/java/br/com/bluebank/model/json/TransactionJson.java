package br.com.bluebank.model.json;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.bluebank.model.Transaction;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 * 
 * Transaction DTO
 */
public class TransactionJson {

	private Long id;
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
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime creationDate;
	
	@JsonCreator
	public TransactionJson(
			@JsonProperty("accountNumberFrom") Integer accountNumberFrom,
			@JsonProperty("accountAgencyFrom") Integer accountAgencyFrom,
			@JsonProperty("accountNumberTo") Integer accountNumberTo,
			@JsonProperty("accountAgencyTo") Integer accountAgencyTo,
			@JsonProperty("amount") BigDecimal amount, 
			@JsonProperty("description") String description) {
		this(0L, accountNumberFrom, accountAgencyFrom, accountNumberTo, accountAgencyTo, amount, description, LocalDateTime.now());
	}
	
	public TransactionJson(
			Long id,
			Integer accountNumberFrom,
			Integer accountAgencyFrom,
			Integer accountNumberTo,
			Integer accountAgencyTo,
			BigDecimal amount, 
			String description,
			LocalDateTime creationDate) {
		this.id = id;
		this.accountNumberFrom = accountNumberFrom;
		this.accountAgencyFrom = accountAgencyFrom;
		this.accountNumberTo = accountNumberTo;
		this.accountAgencyTo = accountAgencyTo;
		this.amount = amount;
		this.description = description;
		this.creationDate = creationDate;
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

	public Long getId() {
		return id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	@Override
	public String toString() {
		return "TransactionJson [id=" + id + ", accountNumberFrom=" + accountNumberFrom + ", accountAgencyFrom="
				+ accountAgencyFrom + ", accountNumberTo=" + accountNumberTo + ", accountAgencyTo=" + accountAgencyTo
				+ ", amount=" + amount + ", description=" + description + ", creationDate=" + creationDate + "]";
	}

	public static List<TransactionJson> fromModel(List<Transaction> transactions) {
		return transactions.stream()
				.map(transaction -> {
					return new TransactionJson(
							transaction.getId(),
							transaction.getAccountFrom().getNumber(),
							transaction.getAccountFrom().getAgency(),
							transaction.getAccountTo().getNumber(),
							transaction.getAccountTo().getAgency(),
							transaction.getAmount(),
							transaction.getDescription(),
							transaction.getCreationDate());
				})
				.collect(Collectors.toList());
	}

}
