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



@WebServlet("/SearchUserCourseServlet")
public class SearchUserCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String cName = request.getParameter("s");

	        CourseService cService = new CourseServiceImpl();
	        List<CourseModel> list = cService.getCourseListByName(cName);

	        UserService user = new UserServiceImpli();
	        Integer userId = (Integer) request.getSession().getAttribute("id");
	        int cnt = 0;

	        for (CourseModel cm : list) {
	            ++cnt;
	            boolean enrolled = user.isEnrolled(userId, cm.getCid());
	            out.println("<tr>");
	            out.println("<td>" + cnt + "</td>");
	            out.println("<td>" + cm.getCname() + "</td>");
	            out.println("<td>" + cm.getInstructor() + "</td>");
	            out.println("<td>" + cm.getDuration() + "</td>");
	            out.println("<td>" + cm.getDesc() + "</td>");
	            
	            if (enrolled) {
	                out.println("<td><button disabled style='background:red;color:white;padding:8px 15px;border:none;border-radius:5px;'>Enrolled</button></td>");
	            } else {
	                out.println("<td><a href='EnrollServlet?cid=" + cm.getCid() + "'>");
	                out.println("<button style='background:green;color:white;padding:8px 15px;border:none;border-radius:5px;'>Enroll</button>");
	                out.println("</a></td>");
	            }
	            out.println("</tr>");
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
