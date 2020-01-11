package com.revature.dao;



import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbDao {
	List<Reimbursement> getReimbursements(long userId);
}
