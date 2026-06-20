package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.techhub.Model.RegisterModel;
import org.techhub.Service.*;



@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        RegisterModel user = (RegisterModel) request.getSession().getAttribute("user");

        if (user == null) {
            response.getWriter().write("Session Expired");
            return;
        }

        int userId = user.getUid();

        UserService service = new UserServiceImpli();
        boolean result = service.updateProfile(userId, name, email, pass);

        if (result) {
            user.setName(name);
            user.setEmail(email);
            user.setPassword(pass);

            request.getSession().setAttribute("user", user);

            response.getWriter().write("success");

        } else {
            response.getWriter().write("fail");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
