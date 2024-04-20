package com.service.employee.service;
/**
 * This is service implementation class and used for writing business logics
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.employee.model.Employee;
import com.service.employee.repo.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getEmployees() {

		return (List<Employee>) employeeRepo.findAll();
	}

	@Override
	public String createEmployee(Employee employee) {

		employeeRepo.save(employee);
		return "Employee details added successfully";
	}

	@Override
	public List<Employee> getEmployee(Long trainingId) {
		
		return employeeRepo.findTrainingById(trainingId);
	}

}
