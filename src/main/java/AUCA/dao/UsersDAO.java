package AUCA.dao;

import org.hibernate.Session;

import AUCA.model.Users;
import AUCA_Util.HibernateUtil;

public class UsersDAO {
	public Users saveUsers(Users theuser) {
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();
	        
	        session.save(theuser);
	        session.getTransaction().commit();
	        return theuser;
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception as needed
	        return null;
	    }
	}
	
	

}
