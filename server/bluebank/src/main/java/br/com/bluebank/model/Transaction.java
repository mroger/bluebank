package br.com.bluebank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="account_number_from", referencedColumnName="number"),
		@JoinColumn(name="account_agency_from", referencedColumnName="agency")
	})
	private Account accountFrom;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="account_number_to", referencedColumnName="number"),
		@JoinColumn(name="account_agency_to", referencedColumnName="agency")
	})
	private Account accountTo;
	
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
	public Account getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Account accountFrom) {
		this.accountFrom = accountFrom;
	}
	public Account getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(Account accountTo) {
		this.accountTo = accountTo;
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", accountFrom=" + accountFrom + ", accountTo=" + accountTo + ", amount="
				+ amount + ", creationDate=" + creationDate + ", description=" + description + "]";
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
