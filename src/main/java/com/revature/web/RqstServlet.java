package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bo.Reimbursement;
import com.revature.bo.User;
import com.revature.data.UserDaoImpl;
import com.revature.service.UserSvc;
import com.revature.service.UserSvcImpl;

public class RqstServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2175311913683463107L;

	UserSvcImpl userSvc = new UserSvcImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String param = req.getParameter("test");
		res.setContentType("text/plain");
		System.out.println("received GET Request");
		PrintWriter out = res.getWriter();
		out.println("Response back to JavaScript");
	}
	
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException {
/*		//1 get user from session, redirect if no session
		
		//2. get requests from database
		
		Svc userSvc = new UserSvcImpl();
		
		List<Reimbursement> requests  = reimb
		
		//3 send to client.
		
		
		// 1. get received JSON data from request
				BufferedReader br = 
				new BufferedReader(new InputStreamReader(req.getInputStream()));
				
				String json = "";
				if(br != null){
					json = br.readLine();
					System.out.println(json);
				}
				
				// 2. initiate jackson mapper
				ObjectMapper mapper = new ObjectMapper();
		    	
				// 3. Convert received JSON to Article
				Reimbursement article = mapper.readValue(json, Reimbursement.class);

				// 4. Set response type to JSON
				res.setContentType("application/json");		    
		    	
				// 5. Add article to List<Article>
				requests.add(article);

				// 6. Send List<Article> as JSON to client
				//mapper.writeValue(response.getOutputStream(), articles); */
	}
}
