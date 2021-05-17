package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.CourseDao;
import com.saurabh.entity.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;
	
	@Override
	public void createCourse(Course course) {
		
		courseDao.createCourse(course);
	}

	@Override
	public List<Course> updateCourse(Course course) {
		
		return courseDao.updateCourse(course);
	}

	@Override
	public List<Course> deleteCourse(int courseId) {
		
		return courseDao.deleteCourse(courseId);
	}

	@Override
	public List<Course> searchCourse(int courseId) {
		
		return courseDao.searchCourse(courseId);
	}

	@Override
	public List<Course> getCourseList() {
		
		return courseDao.getCourseList();
	}

}
