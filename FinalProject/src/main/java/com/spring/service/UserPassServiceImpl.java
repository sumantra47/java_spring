package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserPassDao;
import com.spring.model.UserPass;

@Service
@Transactional
public class UserPassServiceImpl implements UserPassService {
	
	@Autowired
	UserPassDao userpassdao;
	
	@Override
	@Transactional
	public void addUser(UserPass userpass) {
		userpassdao.addUser(userpass);

	}

	@Override
	public UserPass getUserinfo(String username) {
		return userpassdao.getUserinfo(username);
	}

}
