package com.service.employeetraining.service;
/**
 * This is service Interface used for writing all method defination here.
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.List;

import com.service.employeetraining.model.Employee;

public interface EmployeeTrainingService {
	
	public List<Employee> getEmployeeTraining();
}
