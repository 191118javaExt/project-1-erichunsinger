package com.revature.repositories;



import java.util.List;

import com.revature.models.UserModel;

public interface UsersDAO {




	public void getUser(UserModel u);
	public UserModel verifyUser(UserModel u);
	public List<UserModel> getAllUsers();
	public int insertRequest();
	
	
	
}
