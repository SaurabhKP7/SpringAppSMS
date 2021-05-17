package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.StudentDao;
import com.saurabh.entity.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public void createStudent(Student student) {

		studentDao.createStudent(student);
	}

	@Override
	public List<Student> updateStudent(Student student) {

		return studentDao.updateStudent(student);
	}

	@Override
	public List<Student> deleteStudent(int sid) {

		return studentDao.deleteStudent(sid);
	}

	@Override
	public List<Student> searchStudent(int sid) {
		// TODO Auto-generated method stub
		return studentDao.searchStudent(sid);
	}

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return studentDao.getStudentList();
	}

	@Override
	public Student getStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(student);
	}

	

}
