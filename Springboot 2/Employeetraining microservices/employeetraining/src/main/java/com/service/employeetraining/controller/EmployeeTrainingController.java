package com.service.employeetraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.employeetraining.model.Employee;
import com.service.employeetraining.model.Training;
import com.service.employeetraining.service.EmployeeTrainingService;
import com.service.employeetraining.service.TrainingEmployeeService;

@RestController
public class EmployeeTrainingController {
	@Autowired
	 EmployeeTrainingService  employeeTrainingService;
	
	@GetMapping("/employeetraining")
	public List<Employee> getEmployeeTraining() {
		return employeeTrainingService.getEmployeeTraining();
	}
	@Autowired
	TrainingEmployeeService trainingEmployeeService;

	@GetMapping("/trainingemployee")
	public List<Training> getTrainingEmployee() {
		return trainingEmployeeService.getTrainingEmployee();
	}

}
