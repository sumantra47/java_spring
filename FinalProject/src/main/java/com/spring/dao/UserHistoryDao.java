package com.spring.dao;

import java.util.List;

import com.spring.model.UserHistory;
import com.spring.model.UserTrx;

public interface UserHistoryDao {
	
	public void addtrx(UserHistory userhistory);
	public List<UserHistory> gettalltrx(UserTrx useTrx );

}
