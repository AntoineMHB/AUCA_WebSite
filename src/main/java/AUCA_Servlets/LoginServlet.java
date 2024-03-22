package AUCA_Servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import jakarta.servlet.http.Cookie;

import AUCA_Implementations.UsersDAOImpl;
import AUCA.model.Users;
import AUCA_Interfaces.UsersInterface;
import AUCA_Util.HibernateUtil;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final UsersInterface usersDAO;
    
    public LoginServlet() {
        this.usersDAO = new UsersDAOImpl(HibernateUtil.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_email = request.getParameter("user_email");
        String password = request.getParameter("user_password");
        
        Users theuser = usersDAO.findByEmail(user_email);
        
        if (theuser != null && theuser.getUser_password().equals(password)) {
            // Authentication successful, set user object in session and redirect
            request.getSession().setAttribute("theuser", theuser);
            
            HttpSession session = request.getSession(true);
            Cookie sessionCookie = new Cookie("JSESSIONID", session.getId());
            sessionCookie.setMaxAge(-1); // Cookie lives until the browser is closed
            response.addCookie(sessionCookie);
            response.sendRedirect("index.html");
        } else {
            // Authentication failed, redirect back to login page with error message
            response.sendRedirect("login.html?error=1");
        }
    }
}
