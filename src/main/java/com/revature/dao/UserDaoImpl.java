package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.RvrException;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	// Class Variables
	static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	static final String VERIFY_USER = 
			"select * from project1.ers_user eu \r\n" + 
			"join project1.ers_user_role eur on (eu.role_id = eur.role_id)\r\n" + 
			"where eu.ers_username = ? and eu.ers_password = ?";

	public User verifyUser(String username, String password) {

		String sql = VERIFY_USER;
		User user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			try {

				conn = ConnectionUtil.getConnection();

				stmt = conn.prepareStatement(sql);
				stmt.setObject(1, username);
				stmt.setObject(2, password);
				
				stmt.executeQuery();
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					user = new User();
					user.setUserId(rs.getLong("user_id"));
					user.setUsername(rs.getString("ers_username"));
					user.setPassword(rs.getString("ers_password"));
					user.setFirstName(rs.getString("user_first_name"));
					user.setLastName(rs.getString("user_last_name"));
					user.setEmail(rs.getString("user_email"));
					user.setUserRole(rs.getString("user_role"));
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
		} catch (Exception ex) {
			// logger.log(Level.ERROR,"Error Getting User ",ex);
			RvrException.throwRvrException("Error Getting User ", ex);
		}
		if(user != null) {
			user.setIsLogin(true);
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

}
