package com.spring.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "USERHISTORY")
public class UserHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "serialno")
	private Integer serialno;
	
	@Column(name = "trxdate")
	private Integer trxdate;
	
	@Column(name ="description",nullable = true)
	private String description;
	
	@Column(name = "chequeno",nullable = true)
	private int chequeno;
	
	@Column(name = "withdraw",nullable = true)
	private float withdraw ;
	
	@Column(name = "deposit",nullable = true)
	private float deposit ;
	
	@Column(name = "balance")
	private float balance;
	
	@Transient
	private float trxamt;
	
//	@Transient
//	private String trxtype;
//	
//	public String getTrxtype() {
//		return trxtype;
//	}
//
//	public void setTrxtype(String trxtype) {
//		this.trxtype = trxtype;
//	}
	
	@Transient
	private long tempaccnum;

	public long getTempaccnum() {
		return tempaccnum;
	}

	public void setTempaccnum(long tempaccnum) {
		this.tempaccnum = tempaccnum;
	}

	public float getTrxamt() {
		return trxamt;
	}

	public void setTrxamt(float trxamt) {
		this.trxamt = trxamt;
	}


	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "accountnumber")
	private AccountDetail accountdetail;

	public Integer getSerialno() {
		return serialno;
	}

	public void setSerialno(Integer serialno) {
		this.serialno = serialno;
	}

	public Integer getTrxdate() {
		return trxdate;
	}

	public void setTrxdate(Integer trxdate) {
		this.trxdate = trxdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getChequeno() {
		return chequeno;
	}

	public void setChequeno(int chequeno) {
		this.chequeno = chequeno;
	}

	public float getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(float withdraw) {
		this.withdraw = withdraw;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public AccountDetail getAccountdetail() {
		return accountdetail;
	}

	public void setAccountdetail(AccountDetail accountdetail) {
		this.accountdetail = accountdetail;
	}

	public UserHistory(Integer serialno, Integer trxdate, String description, int chequeno, float withdraw,
			float deposit, float balance, AccountDetail accountdetail) {
		super();
		this.serialno = serialno;
		this.trxdate = trxdate;
		this.description = description;
		this.chequeno = chequeno;
		this.withdraw = withdraw;
		this.deposit = deposit;
		this.balance = balance;
		this.accountdetail = accountdetail;
	}
	
	
	

	@Override
	public String toString() {
		return "UserHistory [serialno=" + serialno + ", trxdate=" + trxdate + ", description=" + description
				+ ", chequeno=" + chequeno + ", withdraw=" + withdraw + ", deposit=" + deposit + ", balance=" + balance
				+ ", trxamt=" + trxamt + ", tempaccnum=" + tempaccnum + ", accountdetail=" + accountdetail + "]";
	}

	public UserHistory() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
