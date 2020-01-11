package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbDao;
import com.revature.dao.ReimbDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbSvcImpl implements ReimbSvc {
	
	//Instance variables
	ReimbDao reimbDao = new ReimbDaoImpl();

	@Override
	public List<Reimbursement> getReimbById(Long id) {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		reimbList = reimbDao.getReimbursements(id);
		return reimbList;
	}


//	@Override
//	public List<Reimbursement> getAll() {
//		List<Reimbursement> reimbs = null;
//		
//		try {
//			reimbs = reimbDao.getAll();
//		}
//		catch (Exception e) {
//			
//		}
//		return reimbs;
//	}
//
//
//	@Override
//	public int create() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
}
