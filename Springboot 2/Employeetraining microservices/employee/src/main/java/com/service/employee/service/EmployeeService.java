package com.service.employee.service;
/**
 * This is service Interface used for writing all method defination here.
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.List;

import com.service.employee.model.Employee;


public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public String createEmployee(Employee employee);
	
	public List<Employee> getEmployee(Long trainingId);

}
