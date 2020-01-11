package com.revature.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;

public class UserSvcImpl implements UserSvc {

	// Instance variables
	UserDao userDao = new UserDaoImpl();

	@Override
	public void verifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Received POST request for user login");
		
		// local variables
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		BufferedReader br = request.getReader();
		StringBuilder sb = new StringBuilder();
		
		// parses Post body into string		
		String line = "";
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String postBodyData = sb.toString();
		System.out.println(sb.toString());
		
		// serializes string data into User model using Jackson
		User user = om.readValue(postBodyData, User.class);
		
		// calls user service method to verify user
		user = userDao.verifyUser(user.getUsername(), user.getPassword());
		
		// check condition if user logged in successfully
		if (user.isLogin()) {
			System.out.println(user.toString());
			
			// using Jackson to serialize User model into JSON string
			String json = om.writeValueAsString(user);
			
			// using PrintWriter to send back a response with the JSON string
			out.append(json);
		} else {
			response.sendError(HttpServletResponse.SC_NO_CONTENT, "Invalid credentials");
		}
	}
}
