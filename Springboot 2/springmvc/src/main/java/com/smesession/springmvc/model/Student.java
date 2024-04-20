package com.smesession.springmvc.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * This is student bean
 * 
 * @author Harsha
 *
 */
public class Student {
	@NotNull
	@Length(min=1)
	private String name;
	@NotNull
	@Size(min=21,max=58)
	private int age;
	@NotNull
	@Min(10)
	private String mobileNumber;
	@NotNull
	private LocalDate dateOfBirth; //add the property
	@NotNull
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
	public Student(@NotNull @Length(min = 1) String name, @NotNull @Size(min = 21, max = 58) int age,
			@NotNull @Min(10) String mobileNumber, @NotNull LocalDate dateOfBirth, @NotNull Exam exam) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.exam = exam;
	}
}