package org.techhub.Controller;

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


/**
 * Servlet implementation class SearchCourseServlet
 */
@WebServlet("/SearchCourseServlet")
public class SearchCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cName=request.getParameter("s");
		//out.println(cName);
		CourseService cService =new CourseServiceImpl();
		List<CourseModel> list=cService.getCourseListByName(cName);
		String str="";
		int cnt=0;
		for(CourseModel cm:list)
		{
			++cnt;
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
		out.println(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
