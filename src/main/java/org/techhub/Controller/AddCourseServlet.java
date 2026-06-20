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
import org.techhub.Service.*;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet
{
protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

RequestDispatcher r=request.getRequestDispatcher("AdminDashboard.html");
r.include(request,response);

out.println("<script>");
out.println("document.querySelector('.content').innerHTML=`");

out.println("<div style='max-width:700px;margin:auto;background:rgba(255,255,255,0.95);padding:35px;border-radius:12px;box-shadow:0px 0px 10px gray;'>");
out.println("<h2 style='text-align:center;color:#2c3e50;margin-bottom:30px;'>Add New Course</h2>");

out.println("<form action=\"AddCourseServlet\" method=\"post\">");

out.println("<div style='margin-bottom:20px;'>");
out.println("<label><b>Course Name</b></label>");
out.println("<input type='text' name='name' style='width:100%;padding:12px;border:1px solid #ccc;border-radius:6px;'>");
out.println("</div>");

out.println("<div style='margin-bottom:20px;'>");
out.println("<label><b>Instructor Name</b></label>");
out.println("<input type='text' name='instructor' style='width:100%;padding:12px;border:1px solid #ccc;border-radius:6px;'>");
out.println("</div>");

out.println("<div style='margin-bottom:20px;'>");
out.println("<label><b>Duration</b></label>");
out.println("<input type='text' name='duration' style='width:100%;padding:12px;border:1px solid #ccc;border-radius:6px;'>");
out.println("</div>");

out.println("<div style='margin-bottom:20px;'>");
out.println("<label><b>Description</b></label>");
out.println("<textarea name='desc' rows='4' style='width:100%;padding:12px;border:1px solid #ccc;border-radius:6px;'></textarea>");
out.println("</div>");

out.println("<div style='text-align:center;'>");
out.println("<input type='submit' name='s' value='Add Course' style='background:#2c3e50;color:white;padding:12px 30px;border:none;border-radius:6px;'>");
out.println("</div>");

out.println("</form>");

String btn=request.getParameter("s");

if(btn!=null)
{
CourseModel cm=new CourseModel();

cm.setCname(request.getParameter("name"));
cm.setInstructor(request.getParameter("instructor"));
cm.setDuration(request.getParameter("duration"));
cm.setDesc(request.getParameter("desc"));

CourseService cs=new CourseServiceImpl();
boolean b=cs.isAddCourse(cm);

if(b)
{
out.println("<h3 style='color:green;text-align:center;margin-top:20px;'>Course Added Successfully</h3>");
}
else
{
out.println("<h3 style='color:red;text-align:center;margin-top:20px;'>Course Not Added</h3>");
}
}

out.println("</div>");

out.println("`;");
out.println("</script>");
}

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
doGet(request,response);
}
}