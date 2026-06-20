package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Service.*;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			 response.setContentType("text/html");
			 PrintWriter out=response.getWriter();
			 	String email=request.getParameter("email");
		        String password=request.getParameter("password");

		        ValidateLoginService vservice=new ValidateLoginServiceImpl();

		        String role=vservice.checkLogin(email,password);

		        if(role.equals("admin"))
		        {
//		        	RequestDispatcher r= request.getRequestDispatcher("AdminDashboard.html");
//		        	r.forward(request, response);
		        	response.sendRedirect("AdminDashboard.html");
		        }
		        else if(role.equals("user"))
		        {
//		        	
		        	response.sendRedirect("UserDashboard.html");
		        }
		        else
		        {
//		        	RequestDispatcher r= request.getRequestDispatcher("login.html");
//		        	r.forward(request, response);
		        	response.sendRedirect("login.html");
		        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
