package br.com.bluebank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	private Long id;
	private Integer accountNumberFrom;
	private Integer accountAgencyFrom;
	private Integer accountNumberTo;
	private Integer accountAgencyTo;
	private BigDecimal amount;
	private LocalDateTime creationDate;
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAccountNumberFrom() {
		return accountNumberFrom;
	}
	public void setAccountNumberFrom(Integer accountNumberFrom) {
		this.accountNumberFrom = accountNumberFrom;
	}
	public Integer getAccountAgencyFrom() {
		return accountAgencyFrom;
	}
	public void setAccountAgencyFrom(Integer accountAgencyFrom) {
		this.accountAgencyFrom = accountAgencyFrom;
	}
	public Integer getAccountNumberTo() {
		return accountNumberTo;
	}
	public void setAccountNumberTo(Integer accountNumberTo) {
		this.accountNumberTo = accountNumberTo;
	}
	public Integer getAccountAgencyTo() {
		return accountAgencyTo;
	}
	public void setAccountAgencyTo(Integer accountAgencyTo) {
		this.accountAgencyTo = accountAgencyTo;
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", accountNumberFrom=" + accountNumberFrom + ", accountAgencyFrom="
				+ accountAgencyFrom + ", accountNumberTo=" + accountNumberTo + ", accountAgencyTo=" + accountAgencyTo
				+ ", amount=" + amount + ", creationDate=" + creationDate + ", description=" + description + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
		
}
