package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.AccountDetailDao;
import com.spring.model.AccountDetail;

@Service
@Transactional
public class AccountDetailServiceImpl implements AccountDetailService {
	
	@Autowired
	AccountDetailDao accountdetaildao;
	
	@Override
	@Transactional
	public void createaccount(AccountDetail accountdetail) {
		accountdetaildao.createaccount(accountdetail);

	}

	@Override
	public AccountDetail getaccountinfo(long accountnumber) {
		return accountdetaildao.getaccountinfo(accountnumber);
	}

	@Override
	@Transactional
	public void updateaccountname(long accountnumber, String name) {
		accountdetaildao.updateaccountname(accountnumber, name);

	}

	@Override
	public float getaccbalance(long accountnumber) {
		return accountdetaildao.getaccbalance(accountnumber);
	}

	@Override
	@Transactional
	public void updateaccbalance(long accountnumber, float balance) {
		accountdetaildao.updateaccbalance(accountnumber, balance);

	}

}
