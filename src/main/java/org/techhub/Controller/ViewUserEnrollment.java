package org.techhub.Controller;

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



@WebServlet("/ViewUserEnrollment")
public class ViewUserEnrollment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        
		PrintWriter out = response.getWriter();
        int userId = (Integer) request.getSession().getAttribute("id");
        
        UserService service = new UserServiceImpli();
        List<EnrollmentsModel> list = service.viewEnrollment(userId);

        out.println("<h2>My Learning</h2>");
        out.println("<table border='1' style='width:100%;text-align:center;  margin-top:20px;'>");

        out.println("<tr>");
        out.println("<th>SR NO</th>");
        out.println("<th>Course Name</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");

        int count = 0;

        for (EnrollmentsModel em : list) {
            ++count;

            out.println("<tr>");
            out.println("<td>" + count + "</td>");

        
            out.println("<td>" + em.getCname() + "</td>");
            if (em.getStatus() == 1) {
                out.println("<td style='color:green;'>Active</td>");
            } else {
                out.println("<td style='color:red;'>Inactive</td>");
            }

            out.println("</tr>");
        }

        out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
