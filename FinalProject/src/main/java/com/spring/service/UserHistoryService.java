package com.spring.service;

import java.util.List;

import com.spring.model.UserHistory;
import com.spring.model.UserTrx;

public interface UserHistoryService {
	
	public void addtrx(UserHistory userhistory);
	public List<UserHistory> gettalltrx(UserTrx useTrx );

}
