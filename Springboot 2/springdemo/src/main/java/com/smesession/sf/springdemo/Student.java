package com.smesession.sf.springdemo;

import java.util.Date;

public class Student {
	private String name;
	private int age;
	private String mobileNumber;
	private Date dateOfBirth;
	
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mobileNumber=" + mobileNumber + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	public Student(String name, int age, String mobileNumber, Date dateOfBirth) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
	}
	public Student(String name, String mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}	

}
