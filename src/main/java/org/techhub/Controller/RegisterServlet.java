package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.RegisterModel;
import org.techhub.Service.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String pass=request.getParameter("password");
			
			RegisterModel model=new RegisterModel();
			model.setName(name);
			model.setEmail(email);
			model.setContact(contact);
			model.setPassword(pass);
			
			RegisterService rService=new RegisterServiceImpl();
			
			boolean result=rService.register(model);
			
			if(result==true)
			{
				 response.sendRedirect("login.html");
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
