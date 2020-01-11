package com.revature.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbDao;
import com.revature.dao.ReimbDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbSvcImpl implements ReimbSvc {
	
	//Instance variables
	ReimbDao reimbDao = new ReimbDaoImpl();

	@Override
	public void getReimbById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();


		System.out.println("Received POST request for user login");
		
		// local variables
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		
		// parses header to get id 	
		Long id = Long.parseLong(request.getHeader("id"));

		// calls user service method to verify user
		reimbList = reimbDao.getReimbursements(id);
		
		// check condition if user logged in successfully
		if (reimbList.size() != 0) {			
			// using Jackson to serialize User model into JSON string
			String json = om.writeValueAsString(reimbList);
			
			// using PrintWriter to send back a response with the JSON string
			out.append(json);
		} else {
			response.sendError(HttpServletResponse.SC_NO_CONTENT, "Invalid credentials");
		}
	}
}
