package com.yash.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.demo.exception.StudentNotFoundException;
import com.yash.demo.model.Student;
import com.yash.demo.repository.StudentDao;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public String saveEmp(Student s) {
		dao.save(s);
		return "Student Save SuccessFully";
	}

	@Override
	public Student getStudent(int rollno) {
		Optional<Student> id = dao.findById(rollno);
		if (id.isPresent()) {
			return id.get();
		} else {
			throw new StudentNotFoundException();
		}
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public String deletStudent(int rollno) {
		System.out.println("Befor Get");
		Optional<Student> optional = dao.findById(rollno);
		if (optional.isPresent()) {

			dao.deleteById(rollno);
			return "Student Delete By id " + rollno;
		}
		throw new StudentNotFoundException();
	}

	@Override
	public String updateStudent(Student s) {
		Optional<Student> id = dao.findById(s.getRollno());

		if (id.isPresent()) {
			dao.save(s);
			return "Student Data Updated";
		} else {
			throw new StudentNotFoundException();
		}
	}

}
