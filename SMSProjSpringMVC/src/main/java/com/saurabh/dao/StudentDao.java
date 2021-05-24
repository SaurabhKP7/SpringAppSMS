/*
 * 
 */
package com.saurabh.dao;

import java.util.List;

import com.saurabh.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * This Interface is used declare the Methods
 * for CRUD operation on Student Entity
 * @author Saurabh Prasad
 * @version 1.0
 * The Interface StudentDao.
 */
public interface StudentDao {

	/**
	 * Creates the student.
	 *
	 * @param student the student
	 */
	public void createStudent(Student student);
	
	/**
	 * Update student.
	 *
	 * @param student the student
	 * @return the list
	 */
	public List<Student> updateStudent(Student student);
	
	/**
	 * Delete student.
	 *
	 * @param studentId the student id
	 * @return the list
	 */
	public List<Student> deleteStudent(int studentId); 
	
	/**
	 * Search for a student.
	 *
	 * @param studentId the student id
	 * @return the list
	 */
	public List<Student> searchStudent(int studentId);
	
	/**
	 * Gets the student list.
	 *
	 * @return the student list
	 */
	public List<Student> getStudentList();
	
	/**
	 * Gets the student record.
	 *
	 * @param student the student
	 * @return the student
	 */
	public Student getStudent(Student student);
}
