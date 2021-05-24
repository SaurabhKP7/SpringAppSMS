package com.saurabh.service;

import java.util.List;

import com.saurabh.entity.Teacher;

// TODO: Auto-generated Javadoc
/**
 * This Interface is used to declare methods
 * for CRUD operations of Teacher Entity through Teacher Service Layer
 * @author Saurabh Prasad
 * @version 1.0
 * The Interface TeacherService.
 */
public interface TeacherService {

	/**
	 * Creates the teacher.
	 *
	 * @param teacher the teacher
	 */
	public void createTeacher(Teacher teacher);
	
	/**
	 * Update teacher.
	 *
	 * @param teacher the teacher
	 * @return the list
	 */
	public List<Teacher> updateTeacher(Teacher teacher);
	
	/**
	 * Delete teacher.
	 *
	 * @param teacherId the teacher id
	 * @return the list
	 */
	public List<Teacher> deleteTeacher(int teacherId); 
	
	/**
	 * Search teacher.
	 *
	 * @param teacherId the teacher id
	 * @return the list
	 */
	public List<Teacher> searchTeacher(int teacherId);
	
	/**
	 * Gets the teacher list.
	 *
	 * @return the teacher list
	 */
	public List<Teacher> getTeacherList();
	
	/**
	 * Gets the teacher record.
	 *
	 * @param teacher the teacher
	 * @return the teacher
	 */
	public Teacher getTeacher(Teacher teacher);
}
