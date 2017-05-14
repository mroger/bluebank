package br.com.bluebank.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="account_holder")
@IdClass(AccountHolderId.class)
public class AccountHolder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	@Id
	private String cpf;
	@Id
	private Integer accountNumber;
	@Id
	private Integer accountAgency;
	private String name;
	private LocalDateTime creationDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Integer getAccountAgency() {
		return accountAgency;
	}
	public void setAccountAgency(Integer accountAgency) {
		this.accountAgency = accountAgency;
	}
	
	@Override
	public String toString() {
		return "AccountHolder [id=" + id + ", cpf=" + cpf + ", accountNumber=" + accountNumber + ", accountAgency="
				+ accountAgency + ", name=" + name + ", creationDate=" + creationDate + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountAgency == null) ? 0 : accountAgency.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		AccountHolder other = (AccountHolder) obj;
		if (accountAgency == null) {
			if (other.accountAgency != null)
				return false;
		} else if (!accountAgency.equals(other.accountAgency))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
