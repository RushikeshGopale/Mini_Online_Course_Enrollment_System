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
import org.techhub.Service.CourseService;
import org.techhub.Service.CourseServiceImpl;

@WebServlet("/ViewCourseServlet")
public class ViewCourseServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request,response);

		CourseService cservice=new CourseServiceImpl();
		List<CourseModel> list=cservice.getAllCourses();

		out.println("<div class='content'>");

		out.println("<input type='text' class='search-box' placeholder='Search Course' onkeyup='searchCourse(this.value)'>");

		out.println("<div class='table-box'>");

		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>SRNO</th>");
		out.println("<th>Course Name</th>");
		out.println("<th>Instructor</th>");
		out.println("<th>Duration</th>");
		out.println("<th>Description</th>");
		out.println("<th>DELETE</th>");
		out.println("<th>UPDATE</th>");
		out.println("</thead>");
		out.println("<tbody id='tbody'>");
		out.println("</tr>");

		int cnt=0;

		for(CourseModel cm:list)
		{
			cnt++;

			out.println("<tr>");
			out.println("<td>"+cnt+"</td>");
			out.println("<td>"+cm.getCname()+"</td>");
			out.println("<td>"+cm.getInstructor()+"</td>");
			out.println("<td>"+cm.getDuration()+"</td>");
			out.println("<td>"+cm.getDesc()+"</td>");

			out.println("<td><a href='DeleteCourseServlet?cid="+cm.getCid()+"' style='color:red;font-weight:bold;text-decoration:none;'>DELETE</a></td>");

			out.println("<td><a href='UpdateCourseServlet?cid="+cm.getCid()+"&cname="+cm.getCname()+"&instructor="+cm.getInstructor()+"&duration="+cm.getDuration()+"&desc="+cm.getDesc()+"' style='color:blue;font-weight:bold;text-decoration:none;'>UPDATE</a></td>");

			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doGet(request,response);
	}
}