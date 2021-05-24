/*
 * @author Saurabh Prasad
 * @version 1.0
 */
package com.saurabh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saurabh.entity.Course;



// TODO: Auto-generated Javadoc
/**
 * This Class is used to perform CRUD
 * operations on Course Entity which interacts
 * with the Database
 * 
 * @author Saurabh Prasad
 * @version 1.0
 *
 * The Class CourseDaoImpl.
 */
@Repository
public class CourseDaoImpl implements CourseDao {

	
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Gets the current session.
	 *
	 * @return the session
	 */
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	
	/**
	 * Creates the course.
	 *
	 * @param course the course
	 */
	@Override
	public void createCourse(Course course) {
		
		getSession().saveOrUpdate(course);
		System.out.println("Course Saved Successfully");
	}

	
	/**
	 * Update course.
	 *
	 * @param course the course
	 * @return the list
	 */
	@Override
	public List<Course> updateCourse(Course course) {
		
		Query query = getSession().createQuery("update Course me set courseName=:cname,course_duration_months=:cdm,fee=:fee,teacher=:t where courseId =:cid");
		query.setParameter("cname", course.getCourseName());
		query.setParameter("cdm", course.getCourse_duration_months());
		query.setParameter("fee", course.getFee());
		query.setParameter("t", course.getTeacher());
		query.setParameter("cid", course.getCourseId());
		
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getCourseList();
	}

	
	
	/**
	 * Delete course.
	 *
	 * @param courseId the course id
	 * @return the list
	 */
	@Override
	public List<Course> deleteCourse(int courseId) {
		Query query = getSession().createQuery("delete Course me where courseId =:cid");
		query.setParameter("cid", courseId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		
		return getCourseList();
	}

	/**
	 * Search for a course.
	 *
	 * @param courseId the course id
	 * @return the list
	 */
	@Override
	public List<Course> searchCourse(int courseId) {
		
		Query query = getSession().createQuery("from Course where courseId =:cid");
		query.setParameter("cid", courseId);
		List<Course> courseList = query.list();
		
		return courseList;
	}

	/**
	 * Gets the course list.
	 *
	 * @return the course list
	 */
	@Override
	public List<Course> getCourseList() {
		
		Query query = getSession().createQuery("select me from Course me");
		List<Course> courseList = query.list();
		return courseList;
	}

}
