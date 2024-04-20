package com.jpa.o2mdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.o2mdemo.model.Exam;
import com.jpa.o2mdemo.model.Student;
import com.jpa.o2mdemo.repo.ExamRepository;
import com.jpa.o2mdemo.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository stuRepo;
	
	@Autowired
	private ExamRepository examRepo;
	
	public List<Student> getStudents() {
		return (List<Student>) stuRepo.findAll();
	}

	public String createStudent( Student s) {
		if(stuRepo.findById(s.getId()).isEmpty()) {
			for(Exam e: s.getExamList()) {
				examRepo.save(e);
			}
			stuRepo.save(s);
			
			return "Student is successfully created.";
		}
		return "Student already exists.";
		
	}
	
	public Student geStudentById(int id) {

		return stuRepo.findById(id).orElse(null);
	}
	

	public Student updateStudent(Student student) {

		return stuRepo.save(student);
	}

	public Student deleteStudentById(int Id) {

		return stuRepo.findById(Id).orElse(null);

	}

}
