package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;

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
