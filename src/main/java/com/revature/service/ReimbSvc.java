package com.revature.service;

import java.util.List;

import com.revature.bo.Reimbursement;

public interface ReimbSvc {
	
	public Reimbursement getReimbById(Long id);
	public List<Reimbursement> getAll();
	public int create();

}