package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.StudentDao;
import com.saurabh.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * This Class is a Service Layer between the Student Repository
 * and Student REST Controller.
 * @author Saurabh Prasad
 * @version 1.0
 * The Class StudentServiceImpl.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	/** The student dao. */
	@Autowired
	StudentDao studentDao;

	/**
	 * Creates the student.
	 *
	 * @param student the student
	 */
	@Override
	public void createStudent(Student student) {

		studentDao.createStudent(student);
	}

	/**
	 * Update student.
	 *
	 * @param student the student
	 * @return the list
	 */
	@Override
	public List<Student> updateStudent(Student student) {

		return studentDao.updateStudent(student);
	}

	/**
	 * Delete student.
	 *
	 * @param sid the sid
	 * @return the list
	 */
	@Override
	public List<Student> deleteStudent(int sid) {

		return studentDao.deleteStudent(sid);
	}

	/**
	 * Search student.
	 *
	 * @param sid the sid
	 * @return the list
	 */
	@Override
	public List<Student> searchStudent(int sid) {
		// TODO Auto-generated method stub
		return studentDao.searchStudent(sid);
	}

	/**
	 * Gets the student list.
	 *
	 * @return the student list
	 */
	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return studentDao.getStudentList();
	}

	/**
	 * Gets the student record.
	 *
	 * @param student the student
	 * @return the student
	 */
	@Override
	public Student getStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(student);
	}

	

}
