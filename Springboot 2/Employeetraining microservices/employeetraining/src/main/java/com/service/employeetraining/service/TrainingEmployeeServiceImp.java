package com.service.employeetraining.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.employeetraining.model.Employee;
import com.service.employeetraining.model.Training;

@Service
public class TrainingEmployeeServiceImp implements TrainingEmployeeService {

	private final String employeeServiceURL = "http://localhost:2234";
	private final String trainingServiceURL = "http://localhost:2235";
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Training> getTrainingEmployee() {
		Training[] trainingList = (Training[]) restTemplate
				.exchange(trainingServiceURL + "/Trainings/", HttpMethod.GET, null, Training[].class).getBody();

		/*
		 * studList.forEach(s -> { List<Exam> examList = (List<Exam>)
		 * restTemplate.exchange(examServiceURL+"/exams/"+s.getId(),HttpMethod.GET,null,
		 * List.class); s.setExams(examList); });
		 */

		for (Training t : trainingList) {
			Employee[] employeeList = (Employee[]) restTemplate
					.exchange(employeeServiceURL + "/employees/" + t.getTrainingId(), HttpMethod.GET, null,
							Employee[].class)
					.getBody();

			// e.setTraining(Arrays.asList(trainingList));
			t.setEmployee(Arrays.asList(employeeList));

		}
		return Arrays.asList(trainingList);

	}
}