package com.saurabh.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.saurabh.mapped.Person;

@Entity
public class Teacher extends Person implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teacherId;
	
	
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


	public int getTeacherId() {
		return teacherId;
	}


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


	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
