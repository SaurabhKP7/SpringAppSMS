package com.saurabh.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.saurabh.mapped.Person;

// TODO: Auto-generated Javadoc
/**
 * This Class is a Student Entity which has all 
 * the variables related to student details  and has a
 * one-to-one relationship with Course Entity
 * @author Sasikiran Putta
 * @version 1.0
 * The Class Student.
 */
@Entity
public class Student extends Person implements Serializable{

	/** The student id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	/** The register date. */
	private Date registerDate;
	
	/** The course. */
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

	/**
 * Gets the student id.
 *
 * @return the student id
 */
public int getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * Gets the course.
	 *
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * Sets the course.
	 *
	 * @param course the new course
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
	
	

	/**
	 * Gets the register date.
	 *
	 * @return the register date
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * Sets the register date.
	 *
	 * @param registerDate the new register date
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", registerDate=" + registerDate + ", course=" + course
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
	}

	

	
	
	
	
}
