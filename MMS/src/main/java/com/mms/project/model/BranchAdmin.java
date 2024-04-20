package com.mms.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is Branch Admin bean
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
//admin branch model class
@Entity
@Table(name = "Branch_Admin")
@Data
@NoArgsConstructor
public class BranchAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long branchId;
	@NotBlank
	@Length(max = 15, message = "branchname should be of max 15 character")
	private String branchName;
	@NotNull(message = "Please enter quantity ")
	@Min(1)
	private int quantity;
	@NotBlank(message = "Please enter your address")
	private String address;
	@NotBlank(message = "Please enter your Contact Number")
	private String phoneNumber;
	@NotBlank
	@Email(message = "please enter your email")
	private String email;
	@NotBlank(message = "please enter your password")
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

}
