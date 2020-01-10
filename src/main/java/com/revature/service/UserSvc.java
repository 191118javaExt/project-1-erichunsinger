package com.revature.service;

import com.revature.bo.User;

public interface UserSvc {	
	public User verifyUser(String username, String password);
}