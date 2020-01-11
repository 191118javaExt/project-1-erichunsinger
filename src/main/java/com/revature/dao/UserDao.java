package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	public User verifyUser(String username, String password);
	public List<User> getAllUsers();
	public int insert();
}
