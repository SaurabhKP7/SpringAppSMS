
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

// TODO: Auto-generated Javadoc
/**
 * This Class is used to handle all
 * the REST APIs related to the Course Entity.
 *
 * @author Rachana Upputuru
 * @version 1.0
 * The Class CourseRestController.
 */
@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, allowedHeaders = "*")
public class CourseRestController {

	/** The course service. */
	@Autowired
	CourseService courseService;
	
	/**
	 * Gets the course list.
	 *
	 * @return the response entity
	 */
	@GetMapping("/getlist")
	public ResponseEntity<List<Course>> allCourse() {
		
		List<Course> li = courseService.getCourseList();
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(li, HttpStatus.OK);
		
	}
	
	/**
	 * Gets the course record.
	 *
	 * @param courseId the course id
	 * @return the course
	 */
	@GetMapping("/getrecord/{id}")
	public ResponseEntity<List<Course>> getCourse(@PathVariable("id") int courseId) {
		
		List<Course> li = courseService.searchCourse(courseId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(li, HttpStatus.OK);
		
	}
	
	/**
	 * Creates the course.
	 *
	 * @param course the course
	 * @return the course
	 */
	@PostMapping("/insert")
	public Course createCourse(@RequestBody Course course) {
		
		courseService.createCourse(course);
		return course;
	}
	
	/**
	 * Delete course.
	 *
	 * @param courseId the course id
	 * @return the response entity
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Course>> deleteCourse(@PathVariable("id") int courseId) {
		
		List<Course> li = courseService.deleteCourse(courseId);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(li, HttpStatus.OK);
		
	}
	
	
	/**
	 * Update course.
	 *
	 * @param course the course
	 * @return the response entity
	 */
	@PutMapping("/update")
	public ResponseEntity<List<Course>> updateCourse(@RequestBody Course course) {
		
		List<Course> li = courseService.updateCourse(course);
		System.out.println(li);
		
		if(li.isEmpty()) {
			
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Course>>(li, HttpStatus.OK);
		
	}
	
}
