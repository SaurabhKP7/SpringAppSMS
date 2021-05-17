package com.saurabh.service;

import java.util.List;

import com.saurabh.entity.Student;

public interface StudentService {

	public void createStudent(Student student);
	public List<Student> updateStudent(Student student);
	public List<Student> deleteStudent(int sid); 
	public List<Student> searchStudent(int sid);
	public List<Student> getStudentList();
	public Student getStudent(Student student);
}
