package com.service.training.model;
/**
 * This is Training model class and used different annotations for input validations on different input attributes.
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Training {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trainingId;
	@NotEmpty(message = "trainingName is mandatory")
	private String trainingName;
	@Future(message = "startdate should be future date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate startDate;
	@Future(message = "enddate should be future date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate endDate;
	
	private long employeeId;

}
//id, Name, StartDate, EndDate)