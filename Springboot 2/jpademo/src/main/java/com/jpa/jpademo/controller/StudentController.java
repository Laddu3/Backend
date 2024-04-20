package com.jpa.jpademo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.jpademo.model.Student;
import com.jpa.jpademo.service.StudentService;

@Controller
//no request mapping above class name http://localhost:1234
//after adding request mapping above class name http://localhost:1234/studentapp
@RequestMapping("studentapp")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// CR

	@GetMapping("/students")
	@ResponseBody
	// Object will be return as JSON -> JavaScript Object Notation
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping("/student")
	@ResponseBody
	public String createStudent(@Valid @RequestBody Student s, BindingResult result) {
		if (result.hasErrors()) {
			String errMsg = "";
			for (ObjectError err : result.getAllErrors()) {
				errMsg += err.getDefaultMessage() + ",";
			}
			return errMsg;
		} 
		
		return studentService.createStudent(s);
	}
	
	@GetMapping("/getstudent/{id}")
	@ResponseBody
	public Student getById(@PathVariable int id) {

		return studentService.geStudentById(id);
	}

	@PutMapping("/updatestudent")
	@ResponseBody
	public Student update(Student student) {

		return studentService.updateStudent(student);
	}

	@GetMapping("/deletestudent/{Id}")
	@ResponseBody
	public Student deleteById(@PathVariable int Id) {

		return studentService.deleteStudentById(Id);
	}

}
