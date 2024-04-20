package com.service.employeetraining.model;

/**
 * This is Employee training model class and used different annotations for input validations on different input attributes
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

	private Long employeeId;
	@NotEmpty(message = "employeeName is mandatory")
	private String employeeName;
	@Length(min = 10, max = 10, message = "mobileNumber should be exactly 10 numbers")
	private String mobileNumber;
	
	private List<Training> training;
}
