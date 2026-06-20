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

import org.techhub.Model.CourseModel;
import org.techhub.Service.*;

@WebServlet("/ViewAllUserCourse")
public class ViewAllUserCourse extends HttpServlet
{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		RequestDispatcher r=request.getRequestDispatcher("UserDashboard.html");
		r.include(request,response);

		Integer userId=(Integer)request.getSession().getAttribute("id");

		CourseService service=new CourseServiceImpl();
		List<CourseModel> list=service.getAllCourses();

		UserService user=new UserServiceImpli();

		out.println("<div style='margin-left:300px;padding:25px;background:#f1f3f6;min-height:100vh;box-sizing:border-box;'>");

		out.println("<div style='width:100%;background:white;padding:25px;border-radius:8px;box-shadow:0 2px 8px rgba(0,0,0,0.1);box-sizing:border-box;'>");

		out.println("<h2 style='text-align:center;color:#24384d;margin:0 0 20px 0;font-size:34px;'>View Courses</h2>");

		out.println("<input type='text' placeholder='Search Course' onkeyup='searchUserCourse(this.value)' style='width:100%;padding:12px;border:1px solid #ccc;border-radius:6px;margin-bottom:20px;box-sizing:border-box;'>");

		out.println("<table style='width:100%;border-collapse:collapse;'>");

		out.println("<tr style='background:#24384d;color:white;'>");
		out.println("<th style='padding:14px;border:1px solid #ddd;'>SRNO</th>");
		out.println("<th style='padding:14px;border:1px solid #ddd;'>Course Name</th>");
		out.println("<th style='padding:14px;border:1px solid #ddd;'>Instructor</th>");
		out.println("<th style='padding:14px;border:1px solid #ddd;'>Duration</th>");
		out.println("<th style='padding:14px;border:1px solid #ddd;'>Description</th>");
		out.println("<th style='padding:14px;border:1px solid #ddd;'>Enroll</th>");
		out.println("</tr>");

		int count=0;

		for(CourseModel cm:list)
		{
			boolean enrolled=user.isEnrolled(userId,cm.getCid());
			count++;

			out.println("<tr style='text-align:center;'>");
			out.println("<td style='padding:12px;border:1px solid #ddd;'>"+count+"</td>");
			out.println("<td style='padding:12px;border:1px solid #ddd;'>"+cm.getCname()+"</td>");
			out.println("<td style='padding:12px;border:1px solid #ddd;'>"+cm.getInstructor()+"</td>");
			out.println("<td style='padding:12px;border:1px solid #ddd;'>"+cm.getDuration()+"</td>");
			out.println("<td style='padding:12px;border:1px solid #ddd;'>"+cm.getDesc()+"</td>");

			out.println("<td style='padding:12px;border:1px solid #ddd;'>");

			if(enrolled)
			{
				out.println("<button disabled style='background:red;color:white;padding:8px 15px;border:none;border-radius:5px;'>Enrolled</button>");
			}
			else
			{
				out.println("<button onclick='enrollCourse("+cm.getCid()+")' style='background:green;color:white;padding:8px 15px;border:none;border-radius:5px;cursor:pointer;'>Enroll</button>");
			}

			out.println("</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doGet(request,response);
	}
}