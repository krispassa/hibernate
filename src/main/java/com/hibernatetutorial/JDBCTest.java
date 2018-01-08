package com.hibernatetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.dto.Employee;
import com.hibernatetutorial.dto.Student;
import com.hibernatetutorial.hbutils.HibernateUtils;

public class JDBCTest {

	public static void main(String[] args) {
		
		
		
		try
		{
			Scanner sr = new Scanner(System.in);
			System.out.println("Choose the CRUD operation on database. \n1. Add Student. \n2. Add Employee. \n3. Update Student. \n4. Update Employee. \n5. Delete Student. \n6. Delete Employee. \n7. Show Student Info. \n8. Show Employee Info");
			switch(sr.nextInt())
			{
			case 1:
				addStudent();
				break;
			case 2:
				addEmployee();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				updateEmployee();
				break;
			case 5:
				deleteStudent();
				break;
			case 6:
				deleteEmployee();
				break;
			case 7:
				showStudent();
				break;
			case 8:
				showEmployee();
				break;
			default: 
				System.out.print("Invalid Choice");
				break;
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
	}

	private static void showEmployee() {
		
		SessionFactory sef = HibernateUtils.getSessionFactory();
		Session session = sef.getCurrentSession();
		Employee ee = new Employee();
		session.beginTransaction();
		System.out.print("Enter employee ID");
		Scanner sa = new Scanner(System.in);
		session.get(Employee.class, sa.nextInt());
		System.out.println("Employee Details.\nEmployee ID:" + ee.getEid());
		System.out.println("First Name:" + ee.getFname());
		System.out.println("Last Name:" + ee.getLname());
		System.out.println("Email:" + ee.getEmail());
		session.getTransaction().commit();
		session.close();
		sef.close();
	}

	private static void showStudent() {
		// TODO Auto-generated method stub
		
	}

	private static void updateEmployee()  throws Exception{
		// TODO Auto-generated method stub
		
		SessionFactory sef = HibernateUtils.getSessionFactory();
		Session session = sef.getCurrentSession();
		session.beginTransaction();
		System.out.print("Enter employee ID");
		Scanner sa = new Scanner(System.in);
		Employee ee = (Employee)session.get(Employee.class, sa.nextInt());
		System.out.print("Choose from option. \n1. First Name. \n2. Last Name.\n3. Email");
		int c = sa.nextInt();
		switch(c)
		{
		case 1:
			System.out.print("Enter Employee First Name");
			ee.setFname(sa.next());
			break;
		case 2:
			System.out.print("Enter Employee Last Name");
			ee.setLname(sa.next());
			break;
		case 3:
			System.out.print("Enter Employee Email");
			ee.setEmail(sa.next());
			break;
		default:
			System.out.print("Invalid Employee ID.");
			break;
		}
		session.save(ee);
		session.getTransaction().commit();
		session.close();
		sef.close();
		
	}

	private static void updateStudent() {
		
		SessionFactory sef = HibernateUtils.getSessionFactory();
		Session session = sef.getCurrentSession();
		session.beginTransaction();
		System.out.print("Enter employee ID");
		Scanner sa = new Scanner(System.in);
		Student ee = (Student)session.get(Student.class, sa.nextInt());
		System.out.print("Choose from option. \n1. First Name. \n2. Last Name.\n3. Email");
		int c = sa.nextInt();
		switch(c)
		{
		case 1:
			System.out.print("Enter Student First Name");
			ee.setFirstName(sa.next());
			break;
		case 2:
			System.out.print("Enter Student Last Name");
			ee.setLastName(sa.next());
			break;
		case 3:
			System.out.print("Enter Student Email");
			ee.setEmail(sa.next());
			break;
		default:
			System.out.print("Invalid Student ID.");
			break;
		}
		session.save(ee);
		session.getTransaction().commit();
		session.close();
		sef.close();
		
	}

	private static void deleteStudent() {
		
		SessionFactory sef = HibernateUtils.getSessionFactory();
		Session session = sef.getCurrentSession();
		session.beginTransaction();
		System.out.print("Enter Student ID");
		Scanner ss = new Scanner(System.in);
		Student ee = (Student)session.get(Student.class, ss.nextInt());
		System.out.print("Do you want to delete Student. \n1. Yes(1). \n2. No(2)");
		switch(ss.nextInt())
		{
		case 1:
			session.delete(ee);
			session.getTransaction().commit();
			System.out.print("Deleted Successfully!!!");
			break;
		case 2:
			System.out.print("No records have been deleted");
			break;
		default:
			System.out.print("Invalid choice");
		}
		
		session.close();
		sef.close();
		
	}

	private static void deleteEmployee() {
		// TODO Auto-generated method stub
		SessionFactory sef = HibernateUtils.getSessionFactory();
		Session session = sef.getCurrentSession();
		session.beginTransaction();
		System.out.print("Enter Employee ID");
		Scanner ss = new Scanner(System.in);
		Employee ee = (Employee)session.get(Employee.class, ss.nextInt());
		System.out.print("Do you want to delete employee. \n1. Yes(1). \n2. No(2)");
		switch(ss.nextInt())
		{
		case 1:
			session.delete(ee);
			session.getTransaction().commit();
			System.out.print("Deleted Successfully!!!");
			break;
		case 2:
			System.out.print("No records have been deleted");
			break;
		default:
			System.out.print("Invalid choice");
		}
		
		session.close();
		sef.close();
		
		
	}

	private static void addStudent() {
		// TODO Auto-generated method stub
		Student em = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student First Name");
		em.setFirstName(sc.next());
		System.out.print("Enter Student Last Name");
		em.setLastName(sc.next());
		System.out.print("Enter Student Email");
		em.setEmail(sc.next());
		SessionFactory sef = HibernateUtils.getSessionFactory();
		Session session = sef.getCurrentSession();
		session.beginTransaction();
		session.save(em);
		session.getTransaction().commit();
		session.close();
		sef.close();
		
	}

	private static void addEmployee() {
		// TODO Auto-generated method stub
		Employee em = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee First Name");
		em.setFname(sc.next());
		System.out.print("Enter Employee Last Name");
		em.setLname(sc.next());
		System.out.print("Enter Employee Email");
		em.setEmail(sc.next());
		SessionFactory sef = HibernateUtils.getSessionFactory();
		Session session = sef.getCurrentSession();
		session.beginTransaction();
		session.save(em);
		session.getTransaction().commit();
		session.close();
		sef.close();
	}

}
