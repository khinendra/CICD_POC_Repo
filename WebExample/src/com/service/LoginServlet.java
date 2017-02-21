package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		System.out.println("hi... user: "+user);
		String password = (String)request.getParameter("password");
		System.out.println("password: "+password);
		RequestDispatcher rd = null;
		String message = null;
		if(user.equalsIgnoreCase("admin") && password.equals("admin")){			
			request.setAttribute("user", user);
			message = "You are welcome.....";
			rd = request.getRequestDispatcher("./success.jsp");
		}else{
			message = "failed to login.";
			out.write("<html><body><h3>Login failed. Please check your id/password. </h3></body></html>");
			rd = request.getRequestDispatcher("failure.jsp");
		}
		
		request.setAttribute("customMessage", message);
		rd.forward(request, response);
	}

}
