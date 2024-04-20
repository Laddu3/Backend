package com.smesession.sbvalid.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
/**
 * This is Exam bean
 * 
 * @author Harsha
 *
 */
public class Exam {
	// input validations using annotations
	@Length(min = 1, max = 10, message = "name should be between 1 to 10 character")
	private String examName;
	@Future(message = "examdate should be future date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate examDate;

	@Min(value = 0, message = "score should be between 0 and 100")
	@Max(value = 100, message = "score should be between 0 and 100")
	private int score;

	public Exam() {
		super();
	}

//// add date property to the parameterized constructor
	public Exam(String examName, LocalDate examDate, int score) {
		super();
		this.examName = examName;
		this.examDate = examDate;
		this.score = score;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
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

//tostring method
	@Override
	public String toString() {
		return "Exam [ExamName=" + examName + ", examDate=" + examDate + ", score=" + score + "]";
	}
}
