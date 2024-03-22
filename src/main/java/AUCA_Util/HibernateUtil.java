//package AUCA_Util;
//
//import org.hibernate.cfg.Configuration;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import AUCA.model.Student;
//
//public class HibernateUtil {
//    private static final SessionFactory sessionFactory;
//
//     static{
//     
//            try {
//                // Create properties for Hibernate configuration
//                Configuration configuration = new Configuration();
//                configuration.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
//                configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/aganze");
//                configuration.setProperty("hibernate.connection.username", "postgres");
//                configuration.setProperty("hibernate.connection.password","1234");
//                configuration.setProperty("hibernate.connection.dialect","org.hibernate.dialect.PostgreSQL95Dialect");
//                configuration.setProperty("hibernate.hdm2ddl.auto", "update");
//                
//                configuration.addAnnotatedClass(Student.class);
//                
//                sessionFactory = configuration.buildSessionFactory();
//                } catch(Throwable ex) {
//                	//Log the exception.
//                	System.err.println("Initial SessionFactory creation failed:" + ex.getMessage());
//                	throw new ExceptionInInitializerError(ex);
//                }
//            }
//     
//            public static Session getSession() {
//            	try {
//            		return sessionFactory.openSession();
//            		}catch(Exception e) {
//            			//Log the exception and rethrow it.
//            			System.err.println("Failed to open session:" + e.getMessage());
//            			throw e;
//            		}
//            	}
//            }
//               





package AUCA_Util;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import AUCA.model.Users;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create properties for Hibernate configuration
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/auca_system_db");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "1234");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.addAnnotatedClass(Users.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed: " + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        try {
            return sessionFactory.openSession();
        } catch (Exception e) {
            // Log the exception and rethrow it.
            System.err.println("Failed to open session: " + e.getMessage());
            throw e;
        }
    }
    
    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
}