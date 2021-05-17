package com.saurabh.dao;

import java.util.List;

import com.saurabh.entity.Course;

public interface CourseDao {

	public void createCourse(Course course);
	public List<Course> updateCourse(Course course);
	public List<Course> deleteCourse(int courseId); 
	public List<Course> searchCourse(int courseId);
	public List<Course> getCourseList();
//	public Course getCourse(Course course);
}
