package com.revature.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbDao;
import com.revature.dao.ReimbDaoImpl;
import com.revature.model.Reimbursement;
import com.revature.model.User;

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
	
	public void insertTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Received POST request for user login");
		
		// local variables
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		BufferedReader br = request.getReader();
		StringBuilder sb = new StringBuilder();
		
		// parses header to get id 	
		Long id = Long.parseLong(request.getHeader("id"));
		
		// parses Post body into string		
		String line = "";
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String postBodyData = sb.toString();
		System.out.println(sb.toString());
		
		// serializes string data into User model using Jackson
		Reimbursement reim = om.readValue(postBodyData, Reimbursement.class);
		reim.setSubmitDate(Timestamp.from(Instant.now()));
		reim.setAuthorId(id);
		// calls user service method to verify user
		int rowsInserted = reimbDao.insertTicket(reim);
		
		// check condition if user logged in successfully
		if (rowsInserted != 0) {
			
			List<Reimbursement> reimbList = reimbDao.getReimbursements(id);
			// using Jackson to serialize User model into JSON string
			String json = om.writeValueAsString(reimbList);
			
			// using PrintWriter to send back a response with the JSON string
			out.append(json);
		} else {
			response.sendError(HttpServletResponse.SC_NO_CONTENT, "No Content");
		}
	}
}
