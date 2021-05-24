package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.CourseDao;
import com.saurabh.entity.Course;

// TODO: Auto-generated Javadoc
/**
 * This Class is a Service Layer between the Course Repository
 * and Course REST Controller.
 * @author Saurabh Prasad
 * @version 1.0
 * The Class CourseServiceImpl.
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	/** The course dao. */
	@Autowired
	CourseDao courseDao;
	
	/**
	 * Creates the course.
	 *
	 * @param course the course
	 */
	@Override
	public void createCourse(Course course) {
		
		courseDao.createCourse(course);
	}

	/**
	 * Update course.
	 *
	 * @param course the course
	 * @return the list
	 */
	@Override
	public List<Course> updateCourse(Course course) {
		
		return courseDao.updateCourse(course);
	}

	/**
	 * Delete course.
	 *
	 * @param courseId the course id
	 * @return the list
	 */
	@Override
	public List<Course> deleteCourse(int courseId) {
		
		return courseDao.deleteCourse(courseId);
	}

	/**
	 * Search course.
	 *
	 * @param courseId the course id
	 * @return the list
	 */
	@Override
	public List<Course> searchCourse(int courseId) {
		
		return courseDao.searchCourse(courseId);
	}

	/**
	 * Gets the course list.
	 *
	 * @return the course list
	 */
	@Override
	public List<Course> getCourseList() {
		
		return courseDao.getCourseList();
	}

}
