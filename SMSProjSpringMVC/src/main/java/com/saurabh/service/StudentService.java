package com.saurabh.service;

import java.util.List;

import com.saurabh.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * This Interface is used to declare methods
 * for CRUD operations of Student Entity through Student Service Layer
 * @author Saurabh Prasad
 * @version 1.0
 * The Interface StudentService.
 */
public interface StudentService {

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
	 * @param sid the sid
	 * @return the list
	 */
	public List<Student> deleteStudent(int sid); 
	
	/**
	 * Search student.
	 *
	 * @param sid the sid
	 * @return the list
	 */
	public List<Student> searchStudent(int sid);
	
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
