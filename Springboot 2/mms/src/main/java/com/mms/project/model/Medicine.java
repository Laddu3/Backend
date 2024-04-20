package com.mms.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is Medicine bean
 * 
 * @author Team 1
 *
 */
//medicine model class
@Entity
@Table(name = "Medicine")
@Data
@NoArgsConstructor
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long medicineId;
	@NotBlank
	@Length(max = 20, message = "medicine name should be of max 10 character")
	private String medicineName;
	@NotNull
	@Min(1)
	@Positive(message = "Please enter medicine price")
	private int price;
	@NotNull(message = "Please enter stock ")
	@Min(1)
	private int stock;
}