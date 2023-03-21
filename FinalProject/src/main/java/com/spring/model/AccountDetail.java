package com.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ACCOUNTDETAIL")
public class AccountDetail {
	
	@Id
	@Column(name ="accountnumber")
	private long accountnumber;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="acctype")
	private String acctype;
	
	@Column(name ="balance",nullable = false)
	private float balance;
	
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "username")
	private UserPass userpass;
	
	@OneToMany(mappedBy = "accountdetail",fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<UserHistory> userHistory;

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public UserPass getUserpass() {
		return userpass;
	}

	public void setUserpass(UserPass userpass) {
		this.userpass = userpass;
	}

	public List<UserHistory> getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(List<UserHistory> userHistory) {
		this.userHistory = userHistory;
	}

	public AccountDetail(long accountnumber, String name, String address, String email, String acctype, UserPass userpass,
			List<UserHistory> userHistory) {
		super();
		this.accountnumber = accountnumber;
		this.name = name;
		this.address = address;
		this.email = email;
		this.acctype = acctype;
		this.userpass = userpass;
		this.userHistory = userHistory;
	}
	
	public AccountDetail() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside account detail" );
		
	}
	
	
	
	
	
	

}
