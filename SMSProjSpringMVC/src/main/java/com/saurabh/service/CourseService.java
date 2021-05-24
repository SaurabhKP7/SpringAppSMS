package com.saurabh.service;

import java.util.List;

import com.saurabh.entity.Course;

// TODO: Auto-generated Javadoc
/**
 * This Interface is used to declare methods
 * for CRUD operations of Course Entity through Course Service Layer
 * @author Saurabh Prasad
 * @version 1.0
 * The Interface CourseService.
 */
public interface CourseService {

	/**
	 * Creates the course.
	 *
	 * @param course the course
	 */
	public void createCourse(Course course);
	
	/**
	 * Update course.
	 *
	 * @param course the course
	 * @return the list
	 */
	public List<Course> updateCourse(Course course);
	
	/**
	 * Delete course.
	 *
	 * @param courseId the course id
	 * @return the list
	 */
	public List<Course> deleteCourse(int courseId); 
	
	/**
	 * Search course.
	 *
	 * @param courseId the course id
	 * @return the list
	 */
	public List<Course> searchCourse(int courseId);
	
	/**
	 * Gets the course list.
	 *
	 * @return the course list
	 */
	public List<Course> getCourseList();
//	public Course getCourse(Course course);
}
