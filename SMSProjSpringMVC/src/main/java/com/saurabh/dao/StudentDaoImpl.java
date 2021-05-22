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

@Repository
public class StudentDaoImpl implements StudentDao{

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void createStudent(Student student) {
		
		getSession().saveOrUpdate(student);
		System.out.println("Student Saved Successfully");
		
	}

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


	@Override
	public List<Student> searchStudent(int studentId) {
		
		Query query = getSession().createQuery("from Student where studentId =:sid");
		query.setParameter("sid", studentId);
		List<Student> studentList = query.list();
		
		return studentList;
	}


	@Override
	public List<Student> getStudentList() {
		Query query = getSession().createQuery("select me from Student me");
		List<Student> studentList = query.list();
		return studentList;
	}


	@Override
	public Student getStudent(Student student) {
		
		Criteria c = getSession().createCriteria(Student.class);
		c.add(Restrictions.eq("email", student.getEmail()));
		c.add(Restrictions.eq("password", student.getPassword()));
		Student stu =(Student) c.uniqueResult();
		return stu;
	}

	

	
}
