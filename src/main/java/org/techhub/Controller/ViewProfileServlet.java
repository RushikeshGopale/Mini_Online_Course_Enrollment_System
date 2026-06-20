package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.*;

@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RegisterModel user = (RegisterModel) request.getSession().getAttribute("user");

        if (user == null) {
            out.println("<h3>Please Login First</h3>");
            return;
        }

        out.println("<div style='max-width:500px;margin:40px auto;padding:25px;background:#fff;border-radius:10px;box-shadow:0 0 10px rgba(0,0,0,0.1);'>");

        out.println("<h2 style='text-align:center;margin-bottom:20px;'>Update Profile</h2>");

        out.println("<form onsubmit='updateProfile(event)'>");

        out.println("<label>Name</label>");
        out.println("<input type='text' id='name' value='" + user.getName() + "' style='width:100%;padding:10px;margin:8px 0;border:1px solid #ccc;border-radius:5px;'>");

        out.println("<label>Email</label>");
        out.println("<input type='text' id='email' value='" + user.getEmail() + "' style='width:100%;padding:10px;margin:8px 0;border:1px solid #ccc;border-radius:5px;'>");

        out.println("<label>Password</label>");
        out.println("<input type='password' id='pass' value='" + user.getPassword() + "' style='width:100%;padding:10px;margin:8px 0;border:1px solid #ccc;border-radius:5px;'>");

        out.println("<button type='submit' style='width:100%;padding:10px;background:#4CAF50;color:white;border:none;border-radius:5px;font-size:16px;'>Update</button>");

        out.println("</form>");

        out.println("</div>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
