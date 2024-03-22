package AUCA_Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import AUCA.dao.UsersDAO;
import AUCA.model.Users;


@WebServlet("/adminAuthorization")
public class AdminAuthorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UsersDAO usersDao;
    
    public void init() throws ServletException{
    	usersDao = new UsersDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users theuser = (Users)request.getSession().getAttribute("theuser");
		
		if(theuser != null && theuser.getUser_role().equals("Admin")) {
			response.sendRedirect("index.html");
			
		} else {
			// User is not authorized, redirect to access denied page
			
			response.sendRedirect("error500.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
