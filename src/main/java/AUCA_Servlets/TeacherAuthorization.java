package AUCA_Servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import AUCA.model.Users;

@WebServlet("/teacherAuthorization")
public class TeacherAuthorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public TeacherAuthorization() {
		super();
	}
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users theuser = (Users)request.getSession().getAttribute("theuser");
		
		if(theuser != null && (theuser.getUser_role().equals("Admin") || theuser.getUser_role().equals("Teacher"))) {
			response.sendRedirect("serviceCharter.html");
		} else {
			//User is not authorized, redirect to access-denied page
			response.sendRedirect("unauthorized.html");
		}
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
