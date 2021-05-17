package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.TeacherDao;
import com.saurabh.entity.Teacher;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	
	@Override
	public void createTeacher(Teacher teacher) {
		
		teacherDao.createTeacher(teacher);
	}

	@Override
	public List<Teacher> updateTeacher(Teacher teacher) {
		
		return teacherDao.updateTeacher(teacher);
	}

	@Override
	public List<Teacher> deleteTeacher(int teacherId) {
		
		return teacherDao.deleteTeacher(teacherId);
	}

	@Override
	public List<Teacher> searchTeacher(int teacherId) {
		
		return teacherDao.searchTeacher(teacherId);
	}

	@Override
	public List<Teacher> getTeacherList() {
		
		return teacherDao.getTeacherList();
	}

	@Override
	public Teacher getTeacher(Teacher teacher) {
		
		return teacherDao.getTeacher(teacher);
	}

}
