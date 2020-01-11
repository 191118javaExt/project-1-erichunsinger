package com.revature.service;

import com.revature.model.User;

public interface UserSvc {	
	public User verifyUser(String username, String password);
}