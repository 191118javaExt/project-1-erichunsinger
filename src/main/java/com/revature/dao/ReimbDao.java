package com.revature.dao;



import java.sql.Timestamp;
import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbDao {
	List<Reimbursement> getReimbursements(long userId);
	public int insertTicket(Reimbursement reim);
}
