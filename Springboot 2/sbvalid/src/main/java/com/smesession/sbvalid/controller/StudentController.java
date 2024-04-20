package com.smesession.sbvalid.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smesession.sbvalid.model.Student;
import com.smesession.sbvalid.model.Exam;
@Controller
public class StudentController {
	
	//http://localhost:1234/sayhello
	
	@GetMapping("/sayhello")
	@ResponseBody
	public String sayHelloWorld() {
		System.out.println("Hello world");
		return "Hello World";
	}
	
	//http://localhost:1234/student
	
	@GetMapping("/student")
	@ResponseBody
	//Object will be return as JSON -> JavaScript Object Notation
	public Student getStudent() {
		Student s = new Student("Harsha",47,"12345",LocalDate.now());
		return s;
	}
	
	@PostMapping("/student")
	@ResponseBody
	public String createStudent(@Valid @RequestBody Student s, BindingResult result) {
		if(result.hasErrors()) {
			String errMsg ="";
			for( ObjectError err: result.getAllErrors()) {
				errMsg += err.getDefaultMessage() + ",";
			}
			return errMsg;
		}
		return "We are successfully created the student details";
	}
	
	@PostMapping("/exam")
	@ResponseBody
	public String createExam(@Valid @RequestBody Exam e, BindingResult result) {
		if(result.hasErrors()) {
			String errMsg ="";
			for( ObjectError err: result.getAllErrors()) {
				errMsg += err.getDefaultMessage() + ",";
			}
			return errMsg;
		}
		return "We are successfully created the Exam details";
	}

}
