package com.mms.project.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is Admin bean
 * 
 * @author mandala.kamalkishore@hcl.com
 *
 */
//admin model class
@Entity
@Table(name="Admin")
@Data
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@NotNull
	private Long adminId;
	@NotBlank
	@Email(message="please enter your email")
    private String email;
	@NotBlank(message="please enter your password")
	// @Pattern(regexp =
		// "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$")
		/*
		 * ^ represents starting character of the string. (?=.*[0-9]) represents a digit
		 * must occur at least once. (?=.*[a-z]) represents a lower case alphabet must
		 * occur at least once. (?=.*[A-Z]) represents an upper case alphabet that must
		 * occur at least once. (?=.*[@#$%^&-+=()] represents a special character that
		 * must occur at least once. (?=\\S+$) white spaces don’t allowed in the entire
		 * string. .{8, 20} represents at least 8 characters and at most 20 characters.
		 */
	private String password;
	@NotBlank
	@Length(max = 7, message = "firstname should be of max 7 character")
	private String firstName;
	@NotBlank
	@Length(max = 7, message = "lastname should be of max 7 character")
	private String lastName;
	@NotNull
	@Min(18)
	@Positive(message = "Please enter your age")
	private int age;
	@NotBlank(message="Please enter your gender")
	private String gender;
	@Length(min = 10, max = 10, message = "mobileNumber should be exactly 10 numbers")
    private String contactNumber;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "Date of Birth cannot contain future date")
	private LocalDate dateOfBirth;
	

	
}