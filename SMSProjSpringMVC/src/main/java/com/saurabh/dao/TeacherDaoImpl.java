package com.saurabh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saurabh.entity.Teacher;

// TODO: Auto-generated Javadoc
/**
 * This Class is used to perform CRUD
 * operations on Teacher Entity which interacts
 * with the Database
 * @author Saurabh Prasad
 * @version 1.0
 * The Class TeacherDaoImpl.
 */
@Repository
public class TeacherDaoImpl implements TeacherDao {

	
	
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
	 * Creates the teacher.
	 *
	 * @param teacher the teacher
	 */
	@Override
	public void createTeacher(Teacher teacher) {
		
		getSession().saveOrUpdate(teacher);
	}

	/**
	 * Update teacher.
	 *
	 * @param teacher the teacher
	 * @return the list
	 */
	@Override
	public List<Teacher> updateTeacher(Teacher teacher) {
		
		Query query = getSession().createQuery("update Teacher me set firstname=:fname,lastname=:lname,age=:age,gender=:gender,phone=:phone, password=:pass where teacherId =:tid");
		query.setParameter("fname", teacher.getFirstname());
		query.setParameter("lname", teacher.getLastname());
		query.setParameter("age", teacher.getAge());
		query.setParameter("gender", teacher.getGender());
		query.setParameter("phone", teacher.getPhone());
		query.setParameter("pass", teacher.getPassword());
		query.setParameter("tid", teacher.getTeacherId());
		
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getTeacherList();
	}

	/**
	 * Delete teacher.
	 *
	 * @param teacherId the teacher id
	 * @return the list
	 */
	@Override
	public List<Teacher> deleteTeacher(int teacherId) {
		
		Query query = getSession().createQuery("delete Teacher me where teacherId =:tid");
		query.setParameter("tid", teacherId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		
		return getTeacherList();
	}

	/**
	 * Search for a teacher.
	 *
	 * @param teacherId the teacher id
	 * @return the list
	 */
	@Override
	public List<Teacher> searchTeacher(int teacherId) {
		
		Query query = getSession().createQuery("from Teacher where teacherId =:tid");
		query.setParameter("tid", teacherId);
		List<Teacher> teacherList = query.list();
		
		return teacherList;
	}

	/**
	 * Gets the teacher list.
	 *
	 * @return the teacher list
	 */
	@Override
	public List<Teacher> getTeacherList() {
		
		Query query = getSession().createQuery("select me from Teacher me");
		List<Teacher> teacherList = query.list();
		return teacherList;
	}

	/**
	 * Gets the teacher and validates email and password.
	 *
	 * @param teacher the teacher
	 * @return the teacher
	 */
	@Override
	public Teacher getTeacher(Teacher teacher) {
		
		Criteria c = getSession().createCriteria(Teacher.class);
		c.add(Restrictions.eq("email", teacher.getEmail()));
		c.add(Restrictions.eq("password", teacher.getPassword()));
		Teacher t =(Teacher) c.uniqueResult();
		return t;
	}

}
