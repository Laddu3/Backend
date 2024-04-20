package com.service.employee.controller;

/**
 * This is Employee controller class
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.employee.model.Employee;
import com.service.employee.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@PostMapping("/employee")
	public String createEmployee(@Valid @RequestBody Employee e, BindingResult result) {
		log.info("createemployee method is called.");
		if (result.hasErrors()) {
			String errMsg = "";
			for (ObjectError err : result.getAllErrors()) {
				errMsg += err.getDefaultMessage() + ",";
			}
			log.error("Error occurred in createe,ployee method due to data validation:" + errMsg);
			return errMsg;
		}
		log.info("createStudent method completed successfully.");
		String msg = employeeService.createEmployee(e);
		log.debug("Employee ID:" + e.getEmployeeId());
		return msg;
	}

	@GetMapping("/employee/{trainingId}")
	public List<Employee> getEmployee(@PathVariable Long trainingId) {
		return employeeService.getEmployee(trainingId);
	}

}