package com.yash.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;

import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yash.demo.model.Student;
import com.yash.demo.service.StudentService;

@RestController
@RequestMapping("/StuApp")
public class ControllerClass {

	@Autowired
	private StudentService service;

	Logger logger = LoggerFactory.getLogger(ControllerClass.class);

	@GetMapping("/home")
	public String check() {
		logger.info("");
		return "Student App Working";
	}

	@PostMapping("/insertStudent")
	public ResponseEntity<String> AddStudent(@RequestBody Student s) {
		String s1 = service.saveEmp(s);
		System.out.println(s1);
		
		return new ResponseEntity<String>("Data Save", HttpStatus.CREATED);
	}

	@GetMapping("/getAllStu")
	public ResponseEntity<List<StudentService>> getAllStu() {

		List<Student> list = service.getAllStudent();
				return new ResponseEntity<List<Student>>(HttpStatus.OK);

	}

	@GetMapping("/getSingle/{id}")
	public Student getStudent(@PathVariable int id) {

		Student student = service.getStudent(id);
		return student;
	}

	@DeleteMapping("/deletStu/{id}")
	public String deleteStu(@PathVariable int id) {

		String string = service.deletStudent(id);
		return string;
	}

	@PutMapping("/updateStu")
	public String updateStudent(@RequestBody Student s) {
		String string = service.updateStudent(s);
		return string;
	}

}
