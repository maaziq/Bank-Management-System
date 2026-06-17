package jsp.springboot.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankId;
	private String bankName;
	
	@Column(unique = true)
	private String ifscCode;
	private String branch;
	
	@Column(unique = true)
	private Long contact;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bankAcc", cascade = CascadeType.ALL)
	private List<Account> account;


	public List<Account> getAccount() {
		return account;
	}
	
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Integer getId() {
		return bankId;
	}
	
	public void setId(Integer bankId) {
		this.bankId = bankId;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getIfscCode() {
		return ifscCode;
	}
	
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public Long getContact() {
		return contact;
	}
	
	public void setContact(Long contact) {
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return "Bank [id=" + bankId + ", bankName=" + bankName + ", ifscCode=" + ifscCode + ", branch=" + branch
				+ ", contact=" + contact + ", address=" + address + "]";
	}
	
	
}
