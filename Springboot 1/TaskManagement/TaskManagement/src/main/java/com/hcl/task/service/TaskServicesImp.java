package com.hcl.task.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.task.entity.TaskEntity;
import com.hcl.task.repository.TaskRepository;

@Service 
public class TaskServicesImp implements TaskService {
	

		@Autowired  //used to inject the object dependency implicitly
		TaskRepository taskRepo;
		//to add the vehicle data into database 
		public TaskEntity addTask(TaskEntity task) {

			return taskRepo.save(task);

		}
		//to retrieve the vehicle data into database 
		public List<TaskEntity> getTask() {

			return taskRepo.findAll();
		}
		//to update the vehicle data into database by id
		public TaskEntity updateTask(Integer id, TaskEntity task) {

			TaskEntity utask = taskRepo.findById(id).get();

			utask.setTaskName(task.getTaskName());
			utask.setStatus(task.getStatus());
			utask.setStartDate(task.getStartDate());
			utask.setEndDate(task.getEndDate());
			return taskRepo.save(utask);

		}
		//to delete the vehicle data into database by id

		public void deleteTask(Integer id) {
			
			taskRepo.deleteById(id);

		}
		//to get the vehicle data into database by id
		public TaskEntity getTaskbyId(Integer id) {

			return taskRepo.findById(id).get();
		}
		


}
