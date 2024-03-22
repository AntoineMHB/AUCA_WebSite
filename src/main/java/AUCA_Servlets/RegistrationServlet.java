package AUCA_Servlets;

import java.io.IOException;



import AUCA.dao.UsersDAO;
import AUCA.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests if needed
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_email = request.getParameter("user_email");
        String user_password = request.getParameter("user_password");
        String user_role = request.getParameter("user_role");
      

       /* if (!password.equals(confirmPassword)) {
            response.sendRedirect("Index.html");
            return; // Passwords don't match, stop further processing
        }*/

        Users theuser = new Users();
        
        theuser.setUser_email(user_email);
        theuser.setUser_password(user_password);
        theuser.setUser_role(user_role);
       

        UsersDAO dao = new UsersDAO();
        try {
        	
           dao.saveUsers(theuser); // Perform database operation

            // Redirect to login page after successful registration
            response.sendRedirect("Login.html");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            response.sendRedirect("error404.html"); // Redirect to an error page
        }
    }
}