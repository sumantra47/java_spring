package com.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USERPASS")
public class UserPass {
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "userpass")
	@JsonManagedReference
	private List<AccountDetail> accountDetail;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountDetail> getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(List<AccountDetail> accountDetail) {
		this.accountDetail = accountDetail;
	}

	public UserPass(String username, String password, List<AccountDetail> accountDetail) {
		super();
		this.username = username;
		this.password = password;
		this.accountDetail = accountDetail;
	}
	
	public UserPass() {
		// TODO Auto-generated constructor stub
	}
	
	

}
