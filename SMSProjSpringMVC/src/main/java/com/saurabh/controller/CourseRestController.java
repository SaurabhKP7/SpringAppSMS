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

import com.saurabh.entity.Course;
import com.saurabh.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, allowedHeaders = "*")
public class CourseRestController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/getlist")
	private ResponseEntity<List<Course>> allCourse() {
		
		List<Course> li = courseService.getCourseList();
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(li, HttpStatus.OK);
		
	}
	
	@GetMapping("/getrecord/{id}")
	private ResponseEntity<List<Course>> getCourse(@PathVariable("id") int courseId) {
		
		List<Course> li = courseService.searchCourse(courseId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(li, HttpStatus.OK);
		
	}
	
	@PostMapping("/insert")
	private Course createCourse(@RequestBody Course course) {
		
		courseService.createCourse(course);
		return course;
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<List<Course>> deleteCourse(@PathVariable("id") int courseId) {
		
		List<Course> li = courseService.deleteCourse(courseId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(li, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/update")
	private ResponseEntity<List<Course>> updateCourse(@RequestBody Course course) {
		
		List<Course> li = courseService.updateCourse(course);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(li, HttpStatus.OK);
		
	}
	
}
