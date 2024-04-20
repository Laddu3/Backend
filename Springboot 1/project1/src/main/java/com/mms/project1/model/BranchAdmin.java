package com.mms.project1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class BranchAdmin {
	
	//@javax.persistence.Id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long branchId;
	
	//@NotBlank(message = "Name is mandatory")
	private String branchName;
	
	//@NotBlank(message = "Name is mandatory")
	private String address;
	
	//@NotBlank(message = "Name is mandatory")
	private String contactNumber;
	
	//@Email(message = "Not in email format")
	private String email;
	
	private String password;
	

}
 