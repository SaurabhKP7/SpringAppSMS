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

import com.saurabh.entity.Teacher;
import com.saurabh.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, allowedHeaders = "*")
public class TeacherRestController {

	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/getlist")
	private ResponseEntity<List<Teacher>> allTeacher() {
		
		List<Teacher> li = teacherService.getTeacherList();
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Teacher>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Teacher>>(li, HttpStatus.OK);
		
	}
	
	@GetMapping("/getrecord/{id}")
	private ResponseEntity<List<Teacher>> getTeacher(@PathVariable("id") int teacherId) {
		
		List<Teacher> li = teacherService.searchTeacher(teacherId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Teacher>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Teacher>>(li, HttpStatus.OK);
		
	}
	
	@PostMapping("/insert")
	private Teacher createTeacher(@RequestBody Teacher teacher) {
		
		teacherService.createTeacher(teacher);
		return teacher;
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<List<Teacher>> deleteTeacher(@PathVariable("id") int teacherId) {
		
		List<Teacher> li = teacherService.deleteTeacher(teacherId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Teacher>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Teacher>>(li, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/update")
	private ResponseEntity<List<Teacher>> updateTeacher(@RequestBody Teacher teacher) {
		
		List<Teacher> li = teacherService.updateTeacher(teacher);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Teacher>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Teacher>>(li, HttpStatus.OK);
		
	}
	
}
