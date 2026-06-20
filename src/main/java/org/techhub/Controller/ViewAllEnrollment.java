package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.Model.EnrollmentsModel;
import org.techhub.Service.*;



@WebServlet("/ViewAllEnrollment")
public class ViewAllEnrollment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request,response);

		out.println("<div style='margin-left:300px;padding:25px;background:#f1f3f6;min-height:100vh;box-sizing:border-box;'>");

		out.println("<div style='width:100%;background:white;padding:25px;border-radius:8px;box-shadow:0 2px 8px rgba(0,0,0,0.1);box-sizing:border-box;'>");

		out.println("<h2 style='text-align:center;color:#24384d;margin:0 0 20px 0;font-size:34px;'>My Learning</h2>");

		out.println("<table style='width:100%;border-collapse:collapse;'>");

		out.println("<tr style='background:#24384d;color:white;'>");
		out.println("<th style='padding:14px;border:1px solid #ddd;width:15%;'>SR NO</th>");
		out.println("<th style='padding:14px;border:1px solid #ddd;width:45%;'>Course Name</th>");
		out.println("<th style='padding:14px;border:1px solid #ddd;width:40%;'>Student Name</th>");
		out.println("</tr>");

		CourseService courseservice=new CourseServiceImpl();
		List<EnrollmentsModel> list=courseservice.viewAllEnrollment();

		int count=0;

		for(EnrollmentsModel em:list)
		{
			count++;

			out.println("<tr style='text-align:center;'>");
			out.println("<td style='padding:12px;border:1px solid #ddd;'>"+count+"</td>");
			out.println("<td style='padding:12px;border:1px solid #ddd;'>"+em.getCname()+"</td>");
			out.println("<td style='padding:12px;border:1px solid #ddd;'>"+em.getName()+"</td>");
			out.println("</tr>");
		}

		out.println("</table>");

		out.println("</div>");
		out.println("</div>");
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
