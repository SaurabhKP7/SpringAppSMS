package com.saurabh.mapped;

import javax.persistence.MappedSuperclass;

// TODO: Auto-generated Javadoc
/**
 * This is a mapped super class which is has common fields
 * which are applicable to Student and Teacher entity and hence
 * inherited by Student and Teacher Entity
 * @author Sasikiran Putta
 * @version 1.0
 * The Class Person.
 */
@MappedSuperclass
public class Person {

	/** The firstname. */
	public String firstname;
	
	/** The lastname. */
	public String lastname;
	
	/** The age. */
	public int age;
	
	/** The gender. */
	public String gender;
	
	/** The phone. */
	public String phone;
	
	/** The email. */
	public String email;
	
	/** The password. */
	public String password;
	
	
	
	
	/**
	 * Instantiates a new person.
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new person.
	 *
	 * @param firstname the firstname
	 * @param lastname  the lastname
	 * @param age       the age
	 * @param gender    the gender
	 * @param phone     the phone
	 * @param email     the email
	 * @param password  the password
	 */
	public Person(String firstname, String lastname, int age, String gender, String phone, String email,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}


	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}