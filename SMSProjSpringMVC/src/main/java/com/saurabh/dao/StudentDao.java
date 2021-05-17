package com.saurabh.dao;

import java.util.List;

import com.saurabh.entity.Student;

public interface StudentDao {

	public void createStudent(Student student);
	public List<Student> updateStudent(Student student);
	public List<Student> deleteStudent(int studentId); 
	public List<Student> searchStudent(int studentId);
	public List<Student> getStudentList();
	public Student getStudent(Student student);
}
