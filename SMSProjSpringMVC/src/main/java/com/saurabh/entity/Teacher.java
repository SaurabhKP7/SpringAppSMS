package com.saurabh.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.saurabh.mapped.Person;

// TODO: Auto-generated Javadoc
/**
 * This Class is a Teacher Entity which has all 
 * the variables related to teacher details  and has a
 * many-to-one relationship with Course Entity
 * @author Sasikiran Putta
 * @version 1.0
 * The Class Teacher.
 */
@Entity
public class Teacher extends Person implements Serializable{

	/** The teacher id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teacherId;
	
	
	/** The course. */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher", cascade = CascadeType.ALL)
	private Set<Course> course = new LinkedHashSet<Course>();

	
	

//	public Teacher() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Teacher(String firstname, String lastname, int age, String gender, String phone, String email,
//			String password) {
//		super(firstname, lastname, age, gender, phone, email, password);
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Teacher(int teacherId, List<Course> course) {
//		super();
//		this.teacherId = teacherId;
//		this.course = course;
//	}


	/**
 * Gets the teacher id.
 *
 * @return the teacher id
 */
public int getTeacherId() {
		return teacherId;
	}


	/**
	 * Sets the teacher id.
	 *
	 * @param teacherId the new teacher id
	 */
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}


//	public Set<Course> getCourse() {
//		return course;
//	}
//
//
//	public void setCourse(Set<Course> course) {
//		this.course = course;
//	}


	/**
 * To string.
 *
 * @return the string
 */
@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
