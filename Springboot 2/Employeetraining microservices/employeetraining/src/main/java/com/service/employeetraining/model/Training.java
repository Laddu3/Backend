package com.service.employeetraining.model;
/**
 * This is Training model class and used different annotations for input validations on different input attributes.
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Training {
	
	private Long trainingId;
	@NotEmpty(message = "trainingName is mandatory")
	private String trainingName;
	@Future(message = "startdate should be future date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate startDate;
	@Future(message = "enddate should be future date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate endDate;
	
	private List<Employee> employee;
	
	
	
}
//id, Name, StartDate, EndDate)