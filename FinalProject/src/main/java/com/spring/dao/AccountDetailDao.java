package com.spring.dao;

import com.spring.model.AccountDetail;

public interface AccountDetailDao {
	
	public void createaccount(AccountDetail accountdetail);
	public AccountDetail getaccountinfo(long accountnumber);
	public void updateaccountname(long accountnumber, String name);
	public float getaccbalance(long accountnumber);
	public void updateaccbalance(long accountnumber, float balance);

}
