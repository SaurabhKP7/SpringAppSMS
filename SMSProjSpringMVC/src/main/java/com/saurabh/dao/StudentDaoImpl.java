package com.saurabh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.saurabh.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * This Class is used to perform CRUD
 * operations on Student Entity which interacts
 * with the Database
 * @author Saurabh Prasad
 * @version 1.0
 * The Class StudentDaoImpl.
 */
@Repository
public class StudentDaoImpl implements StudentDao{

	
	
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
	 * Creates the student.
	 * 
	 * @param student the student
	 */
	@Override
	public void createStudent(Student student) {
		
		getSession().saveOrUpdate(student);
		System.out.println("Student Saved Successfully");
		
	}

	/**
	 * Update student.
	 *
	 * @param student the student
	 * @return the list
	 */
	@Override
	public List<Student> updateStudent(Student student) {
		
		Query query = getSession().createQuery("update Student me set firstname=:fname,lastname=:lname,age=:age,gender=:gender,phone=:phone, registerDate=:rd, course=:course where studentId =:sid");
		query.setParameter("fname", student.getFirstname());
		query.setParameter("lname", student.getLastname());
		query.setParameter("age", student.getAge());
		query.setParameter("gender", student.getGender());
		query.setParameter("phone", student.getPhone());
		query.setParameter("course", student.getCourse());
		query.setParameter("rd", student.getRegisterDate());
		query.setParameter("sid", student.getStudentId());
		
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getStudentList();
	}

	/**
	 * Delete student.
	 *
	 * @param studentId the student id
	 * @return the list
	 */
	@Override
	public List<Student> deleteStudent(int studentId) {
		
		Query query = getSession().createQuery("delete Student me where studentId =:sid");
		query.setParameter("sid", studentId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		
		return getStudentList();
	}


	/**
	 * Search for a student.
	 *
	 * @param studentId the student id
	 * @return the list
	 */
	@Override
	public List<Student> searchStudent(int studentId) {
		
		Query query = getSession().createQuery("from Student where studentId =:sid");
		query.setParameter("sid", studentId);
		List<Student> studentList = query.list();
		
		return studentList;
	}


	/**
	 * Gets the student list.
	 *
	 * @return the student list
	 */
	@Override
	public List<Student> getStudentList() {
		Query query = getSession().createQuery("select me from Student me");
		List<Student> studentList = query.list();
		return studentList;
	}


	/**
	 * Gets the student record and validates email and password.
	 *
	 * @param student the student
	 * @return the student
	 */
	@Override
	public Student getStudent(Student student) {
		
		Criteria c = getSession().createCriteria(Student.class);
		c.add(Restrictions.eq("email", student.getEmail()));
		c.add(Restrictions.eq("password", student.getPassword()));
		Student stu =(Student) c.uniqueResult();
		return stu;
	}

	

	
}
