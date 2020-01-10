package com.revature.service;

import com.revature.bo.User;
import com.revature.data.UserDao;
import com.revature.data.UserDaoImpl;

public class UserSvcImpl implements UserSvc {

	// Instance variables
	UserDao userDao = new UserDaoImpl();

	@Override
	public User verifyUser(String username, String password) {
		User dbuser;
		dbuser = userDao.verifyUser(username, password);
		return dbuser;
	}
}
