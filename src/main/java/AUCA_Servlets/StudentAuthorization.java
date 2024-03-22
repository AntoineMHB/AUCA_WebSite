package AUCA_Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import AUCA.model.Users;

@WebServlet("/studentAuthorization")
public class StudentAuthorization extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users theuser = (Users) request.getSession().getAttribute("theuser");

        if (theuser == null) {
            System.out.println("User not logged in");
            response.sendRedirect("unauthorized.html");
            return; // Exit the method
        }

        String userRole = theuser.getUser_role();
        if (userRole == null || (!userRole.equals("Admin") && !userRole.equals("Student"))) {
            System.out.println("User is not authorized");
            response.sendRedirect("unauthorized.html");
        } else {
            System.out.println("User role: " + userRole);
            response.sendRedirect("apply.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
