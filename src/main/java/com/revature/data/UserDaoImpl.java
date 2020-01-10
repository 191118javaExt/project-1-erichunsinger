package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.RvrException;
import com.revature.bo.User;
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
				stmt.setString(1, username);
				stmt.setString(2, password);
				
				stmt.executeQuery();
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					user = new User();
					user.setUserId(rs.getLong("USER_ID"));
					user.setUsername(rs.getString("ERS_USERNAME"));
					user.setPassword(rs.getString("ERS_PASSWORD"));
					user.setFirstName(rs.getString("USER_FIRST_NAME"));
					user.setLastName(rs.getString("USER_LAST_NAME"));
					user.setEmail(rs.getString("USER_EMAIL"));
					user.setUserRole(rs.getString("USER_ROLE"));
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
