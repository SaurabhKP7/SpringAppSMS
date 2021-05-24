package com.saurabh.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

// TODO: Auto-generated Javadoc
/**
 * This Class is a Course Entity which has all 
 * the variables related to course details and has a
 * one-to-many relationship with Teacher Entity and one-to-one
 * relationship with Fee Entity
 * @author Sasikiran Putta
 * @version 1.0
 * The Class Course.
 */
@Entity
public class Course implements Serializable {

	/** The course id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	
	/** The course name. */
	private String courseName;
	
	/** The course duration months. */
	private int course_duration_months;
	
	/** The teacher. */
	@ManyToOne
	@JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
	private Teacher teacher;
	
	/** The fee. */
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

	/**
 * Gets the course id.
 *
 * @return the course id
 */
public int getCourseId() {
		return courseId;
	}

	/**
	 * Sets the course id.
	 *
	 * @param courseId the new course id
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * Gets the course name.
	 *
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name.
	 *
	 * @param courseName the new course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the course duration months.
	 *
	 * @return the course duration months
	 */
	public int getCourse_duration_months() {
		return course_duration_months;
	}

	/**
	 * Sets the course duration months.
	 *
	 * @param course_duration_months the new course duration months
	 */
	public void setCourse_duration_months(int course_duration_months) {
		this.course_duration_months = course_duration_months;
	}

	/**
	 * Gets the teacher.
	 *
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * Sets the teacher.
	 *
	 * @param teacher the new teacher
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * Gets the fee.
	 *
	 * @return the fee
	 */
	public Fee getFee() {
		return fee;
	}

	/**
	 * Sets the fee.
	 *
	 * @param fee the new fee
	 */
	public void setFee(Fee fee) {
		this.fee = fee;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", course_duration_months="
				+ course_duration_months + ", teacher=" + teacher + ", fee=" + fee + "]";
	}

	
	
}
