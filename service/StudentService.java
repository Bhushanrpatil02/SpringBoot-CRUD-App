package com.yash.demo.service;

import java.util.List;

import com.yash.demo.model.Student;

public interface StudentService {

	public String saveEmp(Student s);
	public Student getStudent(int rollno);
	public List<Student> getAllStudent();
	public String deletStudent(int rollno);
	public String updateStudent(Student s);
	
}
