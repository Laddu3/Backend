package com.smesession.sbvalid.model;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * This is student bean
 * 
 * @author Harsha
 *
 */
public class Student {
	@Length(max = 10, message = "name should be of max 10 character")
	private String name;

	// Ctrl + Shift + F
	// @Size(min = 21, max = 58)
	@Min(value = 21, message = "age should be between 21 and 58")
	@Max(value = 58, message = "age should be between 21 and 58")
	private int age;

	@Length(min = 10, max = 10, message = "mobileNumber should be exactly 10 numbers")
	private String mobileNumber;

	// @Future
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "Date of Birth cannot contain future date")
	private LocalDate dateOfBirth;
	@Valid
	private Exam exam;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mobileNumber=" + mobileNumber + ", dateOfBirth="
				+ dateOfBirth + ", exam=" + exam + "]";
	}
	/**
	 * @param name
	 * @param age
	 * @param mobileNumber
	 * @param dateOfBirth
	 */
	public Student(@Length(max = 10, message = "name should be of max 10 character") String name,
			@Min(value = 21, message = "age should be between 21 and 58") @Max(value = 58, message = "age should be between 21 and 58") int age,
			@Length(min = 10, max = 10, message = "mobileNumber should be exactly 10 numbers") String mobileNumber,
			@PastOrPresent(message = "Date of Birth cannot contain future date") LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.exam = exam;
	}
}
