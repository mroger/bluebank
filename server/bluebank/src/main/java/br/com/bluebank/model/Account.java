package br.com.bluebank.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Entity account
 */
@Entity
@Table(name="account")
@IdClass(AccountId.class)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer number;
	@Id
	private Integer agency;
	private BigDecimal balance;
	
	public Account() { }
	
	public Account(Integer number, Integer agency) {
		this(number, agency, BigDecimal.ZERO);
	}

	public Account(Integer number, Integer agency, BigDecimal balance) {
		this.number = number;
		this.agency = agency;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getAgency() {
		return agency;
	}
	public void setAgency(Integer agency) {
		this.agency = agency;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", agency=" + agency + ", balance=" + balance + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agency == null) ? 0 : agency.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Account other = (Account) obj;
		if (agency == null) {
			if (other.agency != null)
				return false;
		} else if (!agency.equals(other.agency))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
}
