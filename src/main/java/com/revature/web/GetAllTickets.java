package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.UserSvc;
import com.revature.service.UserSvcImpl;

public class GetAllTickets extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9135301642063176501L;

	UserSvc userSvc = new UserSvcImpl();
	
	protected void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		System.out.println("Received GET request");
		StringBuilder sb = new StringBuilder();
		BufferedReader br = req.getReader();
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = res.getWriter();
		String line = "";
		
		while(br.readLine() != null) {
			
			sb.append(line);
		}
	}
}
