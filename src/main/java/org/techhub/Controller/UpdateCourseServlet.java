package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.CourseModel;
import org.techhub.Service.CourseService;
import org.techhub.Service.CourseServiceImpl;

@WebServlet("/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
		r.include(request,response);

		int cId=Integer.parseInt(request.getParameter("cid"));
		String cName=request.getParameter("cname");
		String instructor=request.getParameter("instructor");
		String duration=request.getParameter("duration");
		String desc=request.getParameter("desc");

		out.println("<div class='content'>");

		out.println("<div style='width:100%;display:flex;justify-content:center;'>");

		out.println("<div style='width:600px;background:white;padding:35px;border-radius:15px;box-shadow:0 4px 14px rgba(0,0,0,0.08);'>");

		out.println("<h2 style='text-align:center;margin-bottom:25px;color:#2c3e50;'>Update Course</h2>");

		out.println("<form action='UpdateCourseServlet' method='POST'>");

		out.println("<input type='hidden' name='id' value='"+cId+"'>");

		out.println("<input type='text' name='name' value='"+cName+"' placeholder='Enter Course Name' style='width:100%;padding:14px;font-size:18px;margin-bottom:15px;border:1px solid #ccc;border-radius:8px;'>");

		out.println("<input type='text' name='instr' value='"+instructor+"' placeholder='Enter Instructor Name' style='width:100%;padding:14px;font-size:18px;margin-bottom:15px;border:1px solid #ccc;border-radius:8px;'>");

		out.println("<input type='text' name='dur' value='"+duration+"' placeholder='Enter Duration' style='width:100%;padding:14px;font-size:18px;margin-bottom:15px;border:1px solid #ccc;border-radius:8px;'>");

		out.println("<input type='text' name='des' value='"+desc+"' placeholder='Enter Description' style='width:100%;padding:14px;font-size:18px;margin-bottom:20px;border:1px solid #ccc;border-radius:8px;'>");

		out.println("<input type='submit' name='s' value='Update Course' style='width:100%;padding:14px;font-size:18px;background:#2c3e50;color:white;border:none;border-radius:8px;cursor:pointer;'>");

		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		int cId=Integer.parseInt(request.getParameter("id"));
		String cName=request.getParameter("name");
		String instructor=request.getParameter("instr");
		String duration=request.getParameter("dur");
		String desc=request.getParameter("des");

		CourseModel cm=new CourseModel();
		cm.setCid(cId);
		cm.setCname(cName);
		cm.setInstructor(instructor);
		cm.setDuration(duration);
		cm.setDesc(desc);

		CourseService cservice=new CourseServiceImpl();
		boolean b=cservice.isupdateCourse(cm);

		if(b)
		{
			response.sendRedirect("ViewCourseServlet");
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h2>Course Not Updated</h2>");
		}
	}
}