package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserHistoryDao;
import com.spring.model.UserHistory;
import com.spring.model.UserTrx;

@Service
@Transactional(readOnly = true)
public class UserHistoryServiceImpl implements UserHistoryService {
	
	@Autowired
	UserHistoryDao userhistorydao;

	@Override
	@Transactional
	public void addtrx(UserHistory userhistory) {
		userhistorydao.addtrx(userhistory);

	}

	@Override
	public List<UserHistory> gettalltrx(UserTrx useTrx) {
		return userhistorydao.gettalltrx(useTrx);
	}

}
