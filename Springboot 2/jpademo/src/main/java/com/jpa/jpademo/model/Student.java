package com.jpa.jpademo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is student bean
 * 
 * @author Harsha
 *
 */
@Entity
@Table(name="Student_table") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id //primary key - CRUDrespository <Student, Integer>
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentid")
	private Exam exam;
}
