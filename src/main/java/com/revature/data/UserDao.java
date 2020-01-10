package com.revature.data;



import java.sql.SQLException;
import java.util.List;

import com.revature.bo.User;

public interface UserDao {
	public User verifyUser(String username, String password);
	public List<User> getAllUsers();
	public int insert();
}
