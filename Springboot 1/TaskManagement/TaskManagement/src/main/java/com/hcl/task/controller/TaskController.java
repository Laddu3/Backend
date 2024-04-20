package com.hcl.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.task.entity.TaskEntity;
import com.hcl.task.service.TaskServicesImp;

@RestController // It is used for making restful web services
@RequestMapping("/taskmanagement") // used to map web requests

public class TaskController {

	@Autowired // used to inject the object dependency implicitly
	TaskServicesImp taskServices;

	@PostMapping("/addtask") // to insert data into database
	public String addtask(@RequestBody TaskEntity task) {
		taskServices.addTask(task);
		return "Task Added Successfully";
	}

	@GetMapping("/gettasks") // to retrieve the data from database
	public List<TaskEntity> getTask() {
		return taskServices.getTask();
	}

	@GetMapping("/gettask/{id}") // to retrieve the data from database by id
	public TaskEntity getTaskbyId(@PathVariable(value = "id") Integer id) {
		return taskServices.getTaskbyId(id);
	}

	@PutMapping("/updatetask/{id}") // to update data from database by id
	public String updateTask(@PathVariable(value = "id") Integer id, @RequestBody TaskEntity task) {
		taskServices.updateTask(id, task);
		return "Task updated successfully";
	}

	@DeleteMapping("/deletetask/{id}") // to delete data from database by id
	public String deleteTask(@PathVariable(value = "id") Integer id) {
		taskServices.deleteTask(id);
		return "Task deleted successfully";
	}

}
