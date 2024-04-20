package com.jpa.jpademo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is Exam bean
 * 
 * @author Harsha
 *
 */
@Entity
@Table(name="Exam_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
	// input validations using annotations
	@Id //primary key - CRUDrespository <Student, Integer>
	private long id;
	@Length(min = 1, max = 10, message = "name should be between 1 to 10 character")
	private String examName;
	@Future(message = "examdate should be future date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate examDate;
	@Min(value = 0, message = "score should be between 0 and 100")
	@Max(value = 100, message = "score should be between 0 and 100")
	private int score;
}
