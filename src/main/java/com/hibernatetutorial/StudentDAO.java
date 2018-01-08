package com.hibernatetutorial;

import java.util.ArrayList;
import java.util.List;

import com.hibernatetutorial.dto.Student;

public class StudentDAO {
	
	List<Student> ls = new ArrayList<Student>();
	
	
	public List<Student> getAllStudent()
	{
		return ls;
	}
	
	public void addStudent(Student s)
	{
		ls.add(s);
		System.out.println("Successfully Added");
	}
	public void deleteStudent(String i)
	{
		ls.remove(i);
	}
	public void findById(String f)
	{
		
	}

}
