package com.smesession.sf.springacdemo;

import java.util.Date;

/**
 * This is student bean
 * 
 * @author Harsha
 *
 */
public class Student {
	private String name;
	private int age;
	private String mobileNumber;
	private Date dateOfBirth; //add the property
	private Exam exam;
	
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
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
				+ dateOfBirth + ", exam=" + exam + "]";
	}
	public Student(String name, int age, String mobileNumber, Date dateOfBirth, Exam exam) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.exam = exam;
	}
	//add date property to the parameterized constructor
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
	//generate setter, getter method for date property
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}	

	
}
