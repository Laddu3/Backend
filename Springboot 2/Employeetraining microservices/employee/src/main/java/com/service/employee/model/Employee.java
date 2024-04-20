package com.service.employee.model;
/**
 * This is Employee model class and used different annotations for input validations on different input attributes.
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	@NotEmpty(message = "employeeName is mandatory")
	private String employeeName;
	@Length(min = 10, max = 10, message = "mobileNumber should be exactly 10 numbers")
	private String mobileNumber;
	
	private Long trainingId;
}
