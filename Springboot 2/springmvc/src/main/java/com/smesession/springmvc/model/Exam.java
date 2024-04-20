package com.smesession.springmvc.model;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * This is Exam bean
 * 
 * @author Harsha
 *
 */
public class Exam {

	@NotNull
	@Length(min=1)
	private String name; 
	@NotNull
    private LocalDate examDate;
	@NotNull
	@Size(min = 0, max = 100)
    private int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getExamDate() {
		return examDate;
	}
	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Exam [name=" + name + ", examDate=" + examDate + ", score=" + score + "]";
	}
	/**
	 * @param name
	 * @param examDate
	 * @param score
	 */
	public Exam(@NotNull @Length(min = 1) String name, @NotNull LocalDate examDate,
			@NotNull @Size(min = 0, max = 100) int score) {
		super();
		this.name = name;
		this.examDate = examDate;
		this.score = score;
	}
   
 
}
