package com.capstone.ams.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * 
 * @author manneusha.sri@hcl.com
 * 
 */

//plane model class
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plane {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long planeId;
	@NotEmpty(message = "plane is mandatory")
	private String planeName;

	
}
