package com.saurabh.dao;

import java.util.List;

import com.saurabh.entity.Teacher;

public interface TeacherDao {

	public void createTeacher(Teacher teacher);
	public List<Teacher> updateTeacher(Teacher teacher);
	public List<Teacher> deleteTeacher(int teacherId); 
	public List<Teacher> searchTeacher(int teacherId);
	public List<Teacher> getTeacherList();
	public Teacher getTeacher(Teacher teacher);
}
