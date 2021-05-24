/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * This Class is used to handle all
 * the REST APIs related to the Student Entity.
 *
 * @author Rachana Upputuru
 * @version 1.0
 * The Class StudentRestController.
 */
@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, allowedHeaders = "*")
public class StudentRestController {

	/** The student service. */
	@Autowired
	StudentService studentService;
	
	/**
	 * Gets the student list.
	 *
	 * @return the response entity
	 */
	@GetMapping("/getlist")
	public ResponseEntity<List<Student>> allStudent() {
		
		List<Student> li = studentService.getStudentList();
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(li, HttpStatus.OK);
		
	}
	
	/**
	 * Gets the student record.
	 *
	 * @param studentId the student id
	 * @return the student
	 */
	@GetMapping("/getrecord/{id}")
	public ResponseEntity<List<Student>> getStudent(@PathVariable("id") int studentId) {
		
		List<Student> li = studentService.searchStudent(studentId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(li, HttpStatus.OK);
		
	}
	
	
	/**
	 * Validate student login.
	 *
	 * @param email    the email
	 * @param password the password
	 * @return the response entity
	 */
	@GetMapping("/validate/email={email}&password={password}")
	public ResponseEntity<Student> validateStudent(@PathVariable("email") String email, @PathVariable("password") String password) {
		
		Student s = new Student();
		s.setEmail(email);
		s.setPassword(password);
		Student student = studentService.getStudent(s);
		System.out.println(student);
		
		if(student == null) {
			
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
		
	}
	
	/**
	 * Creates the student.
	 *
	 * @param student the student
	 * @return the student
	 */
	@PostMapping("/insert")
	public Student createStudent(@RequestBody Student student) {
		
		studentService.createStudent(student);
		return student;
	}
	
	/**
	 * Delete student.
	 *
	 * @param studentId the student id
	 * @return the response entity
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable("id") int studentId) {
		
		List<Student> li = studentService.deleteStudent(studentId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(li, HttpStatus.OK);
		
	}
	
	
	/**
	 * Update student.
	 *
	 * @param student the student
	 * @return the response entity
	 */
	@PutMapping("/update")
	public ResponseEntity<List<Student>> updateStudent(@RequestBody Student student) {
		
		List<Student> li = studentService.updateStudent(student);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(li, HttpStatus.OK);
		
	}
	
	
}
