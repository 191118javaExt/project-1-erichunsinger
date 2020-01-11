package com.revature.service;

import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbSvc {
	
	public List<Reimbursement> getReimbById(Long id);

}