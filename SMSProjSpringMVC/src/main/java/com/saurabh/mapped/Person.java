package com.saurabh.mapped;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

	public String firstname;
	public String lastname;
	public int age;
	public String gender;
	public String phone;
	public String email;
	public String password;
	
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
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


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}