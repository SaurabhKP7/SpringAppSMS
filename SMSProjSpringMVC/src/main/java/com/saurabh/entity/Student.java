package com.saurabh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.saurabh.mapped.Person;

@Entity
public class Student extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseId")
	private Course course;
	
	

//	public Student() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Student(String firstname, String lastname, int age, String gender, String phone, String email,
//			String password) {
//		super(firstname, lastname, age, gender, phone, email, password);
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//
//	public Student(int studentId, Course course) {
//		super();
//		this.studentId = studentId;
//		this.course = course;
//	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", course=" + course + ", firstname=" + firstname + ", lastname="
				+ lastname + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}

	
	
	
	
}
