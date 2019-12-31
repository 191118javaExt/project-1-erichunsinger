package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.UserModel;
import com.revature.utils.ConnectionUtil;

public class UsersDAOImpl implements UsersDAO {
	enum QueryType {
		verifyUser, 
		userInfo
	}
	private UserModel querySQL(UserModel model, String sql, QueryType q) {
		// TODO Auto-generated method stub
		boolean success = false;
		PreparedStatement stmt = null;
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);
			
			if(q == QueryType.verifyUser) {
				stmt.setString(1, model.getUsername());
				stmt.setString(2, model.getPassword());
			} else if (q == QueryType.userInfo){
				stmt.setLong(1, model.getId());
			}
			stmt.executeQuery();
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				
				model.setId(result.getLong("user_id"));
				model.setFirstName(result.getString("user_first_name"));
				model.setLastName(result.getString("user_last_name"));
				model.setEmail(result.getString("user_email"));
				model.setRoleId(String.valueOf(result.getInt("role_id")));
			}
		} catch(SQLException ex) {
			//logger.warn("Unable to retrieve all users", ex);
			
		} finally {
			//CloseStreams.close(stmt);
		}
		
		return model;
	}


	public void getUser(UserModel u) {
		
		String sql = "select * from project1.ers_users where user_id = ?";
		querySQL(u, sql, QueryType.userInfo);
	}

	public UserModel verifyUser(UserModel u) {
		// TODO Auto-generated method stub
		String sql = "select * from postgres.project1.ers_users where ers_username = ? and ers_password = ?";
		
		return querySQL(u, sql, QueryType.verifyUser);
	}

	@Override
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRequest() {
		// TODO Auto-generated method stub
		return 0;
	}

}
