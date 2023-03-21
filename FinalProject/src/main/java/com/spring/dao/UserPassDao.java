package com.spring.dao;

import com.spring.model.UserPass;

public interface UserPassDao {
	
	public void addUser(UserPass userpass);
	public UserPass getUserinfo(String username);

}
