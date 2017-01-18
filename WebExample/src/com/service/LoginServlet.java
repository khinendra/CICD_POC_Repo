package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", description = "LoginServlet", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = (String)request.getParameter("username");
		System.out.println("user: "+user);
		String password = (String)request.getParameter("password");
		System.out.println("password: "+password);
		if(user.equalsIgnoreCase("admin") && password.equals("admin")){
			out.write("<html><body><h1>Welcome Dear : "+user+" </h1></body></html>");
		}else{
			out.write("<html><body><h1>Login failed. Please check your id/password </h1></body></html>");
		}
	}

}
