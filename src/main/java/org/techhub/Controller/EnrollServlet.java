package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.techhub.Service.*;
import org.techhub.Model.*;




@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int courseId=Integer.parseInt(request.getParameter("cid"));
		
		RegisterModel user=(RegisterModel) request.getSession().getAttribute("user");
		int userId=user.getUid();
		
		UserService userservice=new UserServiceImpli();
		boolean result=userservice.enrollCourse(userId, courseId);
		
		response.setContentType("text/plain");

        if (result) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("exists");
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
