package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bo.User;
import com.revature.service.UserSvc;
import com.revature.service.UserSvcImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2175311913683463107L;
	private static final Logger logger = Logger.getLogger(LoginServlet.class);

	UserSvc userSvc = new UserSvcImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		/*
		 * logger.info("**************** log my message ***************"); String param
		 * = req.getParameter("test"); res.setContentType("text/plain");
		 * System.out.println("received GET Request"); PrintWriter out =
		 * res.getWriter(); out.println("Response back to JavaScript");
		 */
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();

		System.out.println("Received POST request");
		String line = "";
		while ((line = br.readLine()) != null) {

			sb.append(line);
		}
		String data = sb.toString();
		System.out.println(sb.toString());
		User user = om.readValue(data, User.class);
		user = userSvc.verifyUser(user.getUsername(), user.getPassword());
		if (user.isLogin()) {
			/*
			 * HttpSession session =request.getSession();
			 * session.setAttribute("username",user.getUsername());
			 */
			System.out.println(user.toString());
			String json = om.writeValueAsString(user);
//			request.getRequestDispatcher("emphome.html").forward(request,response);
			out.append(json);
		} else {
			out.print("Sorry username or password error");
			//request.getRequestDispatcher("index.html").include(request, response);
			// response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}

	}
}
