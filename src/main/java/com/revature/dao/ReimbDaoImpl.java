package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.RvrException;
import com.revature.model.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbDaoImpl implements ReimbDao {
	
	
	// Class Variables
	static final Logger logger = Logger.getLogger(ReimbDaoImpl.class);
	static final String GET_USER_REIMBURSEMENTS = "select * from project1.ers_reimbursement er \r\n" + 
			"join project1.ers_reimbursement_type t on (er.type_id = t.reimbursement_id) \r\n" + 
			"join project1.ers_reimbursement_status s on (er.status_id = s.status_id) \r\n" + 
			"where er.author_id = ?"; 
	//? Takes user id to get the reimbursements associated with the specified author_id

	@Override
	public List<Reimbursement> getReimbursements(long userId) {

		String sql = GET_USER_REIMBURSEMENTS;
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			try {

				conn = ConnectionUtil.getConnection();

				stmt = conn.prepareStatement(sql);
				stmt.setObject(1, userId);
				
				
				stmt.executeQuery();
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					Reimbursement reim = new Reimbursement();
					reim.setReimbId(rs.getLong("reimb_id"));
					reim.setAmount(Double.parseDouble(rs.getString("reimb_amount")));
					reim.setSubmitDate(rs.getTimestamp("reimb_submitted"));
					reim.setResolvedDate(rs.getTimestamp("reimb_resolved"));
					reim.setDescription(rs.getString("reimb_description"));
					reim.setReceipt(rs.getString("reimb_receipt"));
					reim.setAuthorId(Long.parseLong(rs.getString("author_id")));
					reim.setResolverId(Long.parseLong(rs.getString("resolver_id")));
					reim.setTypeId(Long.parseLong(rs.getString("type_id")));
					reim.setStatusId(Long.parseLong(rs.getString("status_id")));
					reim.setStatusStr(rs.getString("reimb_status"));
					reim.setTypeStr(rs.getString("reimbursement_type"));
					reimList.add(reim);
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

		return reimList;
	}


}
