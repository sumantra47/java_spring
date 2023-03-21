package com.spring.service;

import com.spring.model.UserPass;

public interface UserPassService {
	
	public void addUser(UserPass userpass);
	public UserPass getUserinfo(String username);

}
