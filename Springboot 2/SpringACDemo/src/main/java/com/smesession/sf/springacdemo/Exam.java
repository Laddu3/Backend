package com.smesession.sf.springacdemo;

import java.util.Date;

/**
 * This is Exam bean
 * 
 * @author Harsha
 *
 */
public class Exam {

	private String name; 
    private Date examDate;
    private int score;
    public Exam() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
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
	
	public Exam(String name, Date examDate, int score) {
		super();
		this.name = name;
		this.examDate = examDate;
		this.score = score;
	}
    
    

 
}
