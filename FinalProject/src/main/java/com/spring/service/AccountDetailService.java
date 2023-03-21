package com.spring.service;

import com.spring.model.AccountDetail;

public interface AccountDetailService {
	
	public void createaccount(AccountDetail accountdetail);
	public AccountDetail getaccountinfo(long accountnumber);
	public void updateaccountname(long accountnumber, String name);
	public float getaccbalance(long accountnumber);
	public void updateaccbalance(long accountnumber, float balance);

}
