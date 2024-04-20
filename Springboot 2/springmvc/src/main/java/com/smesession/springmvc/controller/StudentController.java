package com.smesession.springmvc.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smesession.springmvc.model.Exam;
import com.smesession.springmvc.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/sayhello")
	@ResponseBody
	public String sayHelloWorld() {
		System.out.println("Hello World ");
		return " Hello World";
	}
	@GetMapping("/student")
	@ResponseBody
	public Student getStudent() {
		Exam e = new Exam("Java",LocalDate.of(2023, 06, 9),80);
		Student s= new Student("Harsha",23,"987654321",LocalDate.of(2001,04, 10),e);
		return s;
	}
}
