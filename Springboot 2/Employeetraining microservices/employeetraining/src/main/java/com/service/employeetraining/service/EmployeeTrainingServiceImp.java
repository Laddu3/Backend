package com.service.employeetraining.service;

/**
 * This is service implementation class and used for writing business logics
 * 
 * @author palagiriharsh.reddy@hcl.com
 *
 */
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.employeetraining.model.Employee;
import com.service.employeetraining.model.Training;

@Service
public class EmployeeTrainingServiceImp implements EmployeeTrainingService {

	private final String employeeServiceURL = "http://localhost:2234";
	private final String trainingServiceURL = "http://localhost:2235";
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Employee> getEmployeeTraining() {
		Employee[] empList = (Employee[]) restTemplate
				.exchange(employeeServiceURL + "/employees", HttpMethod.GET, null, Employee[].class).getBody();

		/*
		 * studList.forEach(s -> { List<Exam> examList = (List<Exam>)
		 * restTemplate.exchange(examServiceURL+"/exams/"+s.getId(),HttpMethod.GET,null,
		 * List.class); s.setExams(examList); });
		 */

		for (Employee e : empList) {
			Training[] trainingList = (Training[]) restTemplate
					.exchange(trainingServiceURL + "/Training/" + e.getEmployeeId(), HttpMethod.GET, null,
							Training[].class)
					.getBody();

			e.setTraining(Arrays.asList(trainingList));

		}
		return Arrays.asList(empList);
	}

}
