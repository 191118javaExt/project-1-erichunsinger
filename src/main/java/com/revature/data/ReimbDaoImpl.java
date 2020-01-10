package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.RvrException;
import com.revature.bo.Reimbursement;
import com.revature.bo.User;
import com.revature.utils.ConnectionUtil;

public class ReimbDaoImpl implements ReimbDao {
	
	
	// Class Variables
	static final Logger logger = Logger.getLogger(ReimbDaoImpl.class);
	static final String GET_REIMBURSEMENTS_BY_USERNAME = 
			"select * "
			+ "from ers.ERS_REIMBURSEMENT reimb, ers.ERS_USER usr, ers.ERS_USER_ROLE rl " 
			+ "where reimb.author = usr.ers_user_id " 
			+ "and usr.reimb_role_id = rl.ers_reimb_role_id and usr.username = ?";
	
	static final String GET_REIMBURSEMENTS_BY_ID = 
			"select * " 
			+ "from ers.ERS_REIMBURSEMENT reimb, ers.ERS_USER usr, ers.ERS_USER_ROLE rl "
			+ "where reimb.author = usr.ers_user_id "
			+ "and usr.reimb_role_id = rl.ers_reimb_role_id and reimb.REIMB_ID = ?";

	@Override
	public Reimbursement getReimbById(Long id) {
		
		String sql = GET_REIMBURSEMENTS_BY_ID;
		Reimbursement reimb = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try { 
			try  {

				conn = ConnectionUtil.getConnection();

				stmt = conn.prepareStatement(sql);	
				stmt.setLong(1, id);

				stmt.executeQuery();
				rs = stmt.executeQuery();

				if(rs.next()) {
					reimb = new Reimbursement();
					reimb.setReimbId(rs.getLong("ers_Reimb_id"));
					reimb.setAmount(rs.getBigDecimal("ers_Reimbname"));
					reimb.setSubmitDate(rs.getTimestamp("ers_password"));
					reimb.setResolvedDate(rs.getTimestamp("Reimb_first_name"));
					User user = new User();
					user.setUserId(rs.getLong("ERS_USER_ID"));
					user.setUsername(rs.getString("USERNAME"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setFirstName(rs.getString("FIRST_NAME"));
					user.setLastName(rs.getString("LAST_NAME"));
					user.setEmail(rs.getString("EMAIL"));
					user.setUserRole(rs.getString("USER_ROLE"));
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			finally {
				if (rs != null) 
					rs.close();
				if (stmt != null) 
					stmt.close();
				if (conn != null) 
					conn.close();
			}	
		} catch (SQLException ex){
			//logger.log(Level.ERROR,"Error Getting Reimb ",ex);
			RvrException.throwRvrException("Error Getting Reimb ", ex);
		}
		return reimb;
	}

	@Override
	public List<Reimbursement> getAll() {
		
		String sql = GET_REIMBURSEMENTS_BY_ID;
		List<Reimbursement> reimbs = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try { 
			try  {

				conn = ConnectionUtil.getConnection();

				stmt = conn.prepareStatement(sql);	
				//stmt.setLong(1, id);

				stmt.executeQuery();
				rs = stmt.executeQuery();
				reimbs = new ArrayList<Reimbursement>();
				while(rs.next()) {
					Reimbursement reimb = new Reimbursement();
					reimb = new Reimbursement();
					reimb.setReimbId(rs.getLong("REIMB_ID"));
					reimb.setAmount(rs.getBigDecimal("AMOUNT"));
					reimb.setSubmitDate(rs.getTimestamp("DTTM_SUBMITTED"));
					reimb.setResolvedDate(rs.getTimestamp("DTTM_RESOLVED"));
					User user = new User();
					user.setUserId(rs.getLong("ERS_USER_ID"));
					user.setUsername(rs.getString("USERNAME"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setFirstName(rs.getString("FIRST_NAME"));
					user.setLastName(rs.getString("LAST_NAME"));
					user.setEmail(rs.getString("EMAIL"));
					user.setUserRole(rs.getString("USER_ROLE"));
					reimb.setUser(user);
					reimbs.add(reimb);
				}

			} catch (SQLException ex) {
				reimbs = null;
				logger.log(Level.ERROR,"Error Getting Reimb ",ex);
			}
			finally {
				if (rs != null) 
					rs.close();
				if (stmt != null) 
					stmt.close();
				if (conn != null) 
					conn.close();
			}	
		} catch (SQLException ex){
			logger.log(Level.ERROR,"Error Getting Reimb ",ex);
			RvrException.throwRvrException("Error Getting Reimb ", ex);
		}
		return reimbs;
	}
	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

}
