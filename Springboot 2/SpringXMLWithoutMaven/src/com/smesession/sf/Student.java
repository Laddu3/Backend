package com.smesession.sf;

public class Student {
	private String name;
	private int age;
	private String mobileNumber;
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
		return "Student [name=" + name + ", age=" + age + ", mobileNumber=" + mobileNumber + "]";
	}
	public Student(String name, int age, String mobileNumber) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
	}
	public Student(String name, String mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}	

}
