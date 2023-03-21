package com.spring.model;

public class UserTrx {
	
	private long accountnumber;
	private int begindate = 010101;
	private int enddate = 010101;
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public int getBegindate() {
		return begindate;
	}
	public void setBegindate(int begindate) {
		this.begindate = begindate;
	}
	public int getEnddate() {
		return enddate;
	}
	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}
	public UserTrx(long accountnumber, int begindate, int enddate) {
		super();
		this.accountnumber = accountnumber;
		this.begindate = begindate;
		this.enddate = enddate;
	}
	
	@Override
	public String toString() {
		return "UserTrx [accountnumber=" + accountnumber + ", begindate=" + begindate + ", enddate=" + enddate + "]";
	}
	public UserTrx() {
		
	}
	
}
