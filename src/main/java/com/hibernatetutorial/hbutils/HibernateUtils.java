package com.hibernatetutorial.hbutils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.dto.Employee;
import com.hibernatetutorial.dto.Student;

public class HibernateUtils {
	
	 private static final SessionFactory sessionFactory;

	 static
	 {
	  try
	  {
	   sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Student.class).buildSessionFactory();
	  }
	  catch(Throwable th){
	   System.err.println("Enitial SessionFactory creation failed"+th);
	   throw new ExceptionInInitializerError(th);
	  }
	   }
	   public static SessionFactory getSessionFactory(){
	    return sessionFactory;
	   }
}
