package AUCA_Implementations;

import AUCA.model.Users;
import AUCA_Interfaces.UsersInterface;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UsersDAOImpl implements UsersInterface{
	
	private final SessionFactory sessionFactory;
	
	public UsersDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Users findByEmail(String user_email) {
		try(Session session = sessionFactory.openSession()){
			Query<Users> query = session.createQuery("FROM Users WHERE user_email = :user_email", Users.class);
			query.setParameter("user_email", user_email);
			return query.uniqueResult();
		}
	}

}
