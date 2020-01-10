package com.revature.service;

import java.util.List;

import com.revature.bo.Reimbursement;
import com.revature.data.ReimbDao;
import com.revature.data.ReimbDaoImpl;

public class ReimbSvcImpl implements ReimbSvc {
	
	//Instance variables
	ReimbDao reimbDao = new ReimbDaoImpl();

	@Override
	public Reimbursement getReimbById(Long id) {
		Reimbursement reimb = null;;
		
		try {
			reimb = reimbDao.getReimbById(id);
		}
		catch (Exception e) {
			
		}
		return reimb;
	}


	@Override
	public List<Reimbursement> getAll() {
		List<Reimbursement> reimbs = null;
		
		try {
			reimbs = reimbDao.getAll();
		}
		catch (Exception e) {
			
		}
		return reimbs;
	}


	@Override
	public int create() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
