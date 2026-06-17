package jsp.springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	private Long accountNumber;
	private String accountHolder;
	private String accountType;
	private Double balance;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bankAcc;
	
	
	public Bank getBankAcc() {
		return bankAcc;
	}
	
	public void setBankAcc(Bank bankAcc) {
		this.bankAcc = bankAcc;
	}
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
}
