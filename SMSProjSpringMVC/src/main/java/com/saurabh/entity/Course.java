package com.saurabh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String courseName;
	private int course_duration_months;
	
	@ManyToOne
	@JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
	private Teacher teacher;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "feeId")
	private Fee fee;

//	public Course() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Course(int courseId, String courseName, int course_duration_months, Teacher teacher, Fee fee) {
//		super();
//		this.courseId = courseId;
//		this.courseName = courseName;
//		this.course_duration_months = course_duration_months;
//		this.teacher = teacher;
//		this.fee = fee;
//	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourse_duration_months() {
		return course_duration_months;
	}

	public void setCourse_duration_months(int course_duration_months) {
		this.course_duration_months = course_duration_months;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", course_duration_months="
				+ course_duration_months + ", teacher=" + teacher + ", fee=" + fee + "]";
	}

	
	
}
