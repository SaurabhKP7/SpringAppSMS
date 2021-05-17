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

@Repository
public class TeacherDaoImpl implements TeacherDao {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createTeacher(Teacher teacher) {
		
		getSession().saveOrUpdate(teacher);
	}

	@Override
	public List<Teacher> updateTeacher(Teacher teacher) {
		
		Query query = getSession().createQuery("update Teacher me set fname=:fname,lname=:lname,age=:age,gender=:gender,phone=:phone where teacherId =:tid");
		query.setParameter("fname", teacher.getFirstname());
		query.setParameter("lname", teacher.getLastname());
		query.setParameter("age", teacher.getAge());
		query.setParameter("gender", teacher.getGender());
		query.setParameter("tid", teacher.getTeacherId());
		
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getTeacherList();
	}

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

	@Override
	public List<Teacher> searchTeacher(int teacherId) {
		
		Query query = getSession().createQuery("from Teacher where teacherId =:tid");
		query.setParameter("tid", teacherId);
		List<Teacher> teacherList = query.list();
		
		return teacherList;
	}

	@Override
	public List<Teacher> getTeacherList() {
		
		Query query = getSession().createQuery("select me from Teacher me");
		List<Teacher> teacherList = query.list();
		return teacherList;
	}

	@Override
	public Teacher getTeacher(Teacher teacher) {
		
		Criteria c = getSession().createCriteria(Teacher.class);
		c.add(Restrictions.eq("email", teacher.getEmail()));
		c.add(Restrictions.eq("password", teacher.getPassword()));
		Teacher t =(Teacher) c.uniqueResult();
		return t;
	}

}
