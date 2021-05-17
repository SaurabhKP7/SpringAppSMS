package com.saurabh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saurabh.entity.Student;
import com.saurabh.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, allowedHeaders = "*")
public class StudentRestController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/getlist")
	private ResponseEntity<List<Student>> allStudent() {
		
		List<Student> li = studentService.getStudentList();
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(li, HttpStatus.OK);
		
	}
	
	@GetMapping("/getrecord/{id}")
	private ResponseEntity<List<Student>> getStudent(@PathVariable("id") int studentId) {
		
		List<Student> li = studentService.searchStudent(studentId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(li, HttpStatus.OK);
		
	}
	
	@PostMapping("/insert")
	private Student createStudent(@RequestBody Student student) {
		
		studentService.createStudent(student);
		return student;
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<List<Student>> deleteStudent(@PathVariable("id") int studentId) {
		
		List<Student> li = studentService.deleteStudent(studentId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(li, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/update")
	private ResponseEntity<List<Student>> updateStudent(@RequestBody Student student) {
		
		List<Student> li = studentService.updateStudent(student);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(li, HttpStatus.OK);
		
	}
	
	
}
