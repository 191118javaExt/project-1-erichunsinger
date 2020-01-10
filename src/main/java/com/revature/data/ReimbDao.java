package com.revature.data;



import java.util.List;

import com.revature.bo.Reimbursement;

public interface ReimbDao {

	public Reimbursement getReimbById(Long id);
	public List<Reimbursement> getAll();
	public int insert();
}
