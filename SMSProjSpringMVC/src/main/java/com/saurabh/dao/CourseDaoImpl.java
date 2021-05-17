package com.saurabh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saurabh.entity.Course;

@Repository
public class CourseDaoImpl implements CourseDao {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void createCourse(Course course) {
		
		getSession().saveOrUpdate(course);
		System.out.println("Course Saved Successfully");
	}

	@Override
	public List<Course> updateCourse(Course course) {
		
		Query query = getSession().createQuery("update Course me set courseName=:cname,course_duration_months=:cdm,feeId=:fid,teacherId=:tid where courseId =:cid");
		query.setParameter("cname", course.getCourseName());
		query.setParameter("cdm", course.getCourse_duration_months());
		query.setParameter("fid", course.getFee());
		query.setParameter("tid", course.getTeacher());
		query.setParameter("cid", course.getCourseId());
		
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getCourseList();
	}

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

	@Override
	public List<Course> searchCourse(int courseId) {
		
		Query query = getSession().createQuery("from Course where courseId =:cid");
		query.setParameter("cid", courseId);
		List<Course> courseList = query.list();
		
		return courseList;
	}

	@Override
	public List<Course> getCourseList() {
		
		Query query = getSession().createQuery("select me from Course me");
		List<Course> courseList = query.list();
		return courseList;
	}

}
