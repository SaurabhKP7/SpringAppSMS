package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.TeacherDao;
import com.saurabh.entity.Teacher;

// TODO: Auto-generated Javadoc
/**
 * This Class is a Service Layer between the Teacher Repository
 * and Teacher REST Controller.
 * @author Saurabh Prasad
 * @version 1.0
 * The Class TeacherServiceImpl.
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	/** The teacher dao. */
	@Autowired
	TeacherDao teacherDao;
	
	/**
	 * Creates the teacher.
	 *
	 * @param teacher the teacher
	 */
	@Override
	public void createTeacher(Teacher teacher) {
		
		teacherDao.createTeacher(teacher);
	}

	/**
	 * Update teacher.
	 *
	 * @param teacher the teacher
	 * @return the list
	 */
	@Override
	public List<Teacher> updateTeacher(Teacher teacher) {
		
		return teacherDao.updateTeacher(teacher);
	}

	/**
	 * Delete teacher.
	 *
	 * @param teacherId the teacher id
	 * @return the list
	 */
	@Override
	public List<Teacher> deleteTeacher(int teacherId) {
		
		return teacherDao.deleteTeacher(teacherId);
	}

	/**
	 * Search teacher.
	 *
	 * @param teacherId the teacher id
	 * @return the list
	 */
	@Override
	public List<Teacher> searchTeacher(int teacherId) {
		
		return teacherDao.searchTeacher(teacherId);
	}

	/**
	 * Gets the teacher list.
	 *
	 * @return the teacher list
	 */
	@Override
	public List<Teacher> getTeacherList() {
		
		return teacherDao.getTeacherList();
	}

	/**
	 * Gets the teacher.
	 *
	 * @param teacher the teacher
	 * @return the teacher
	 */
	@Override
	public Teacher getTeacher(Teacher teacher) {
		
		return teacherDao.getTeacher(teacher);
	}

}
