package com.yash.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.demo.model.Student;
@Repository
public interface StudentDao  extends JpaRepository<Student, Integer>{
	
			Student findByName(String uname);
}
