package AUCA.dao;

import org.hibernate.Session;
import AUCA.model.Student;
import AUCA_Util.HibernateUtil;

public class StudentDAO {
	
	public Student saveStudent(Student student) {
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();
	        
	        session.save(student);
	        session.getTransaction().commit();
	        return student;
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception as needed
	        return null;
	    }
	}
}


