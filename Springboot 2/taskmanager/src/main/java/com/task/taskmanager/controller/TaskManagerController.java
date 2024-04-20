package com.task.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.taskmanager.entity.Task;
import com.task.taskmanager.service.TaskService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class TaskManagerController {
	@Autowired
	TaskService service;

	@PostMapping("/task")
	public String addTask(@RequestBody Task task) {
		return service.addTask(task);
	}

	@DeleteMapping("/{taskId}")
	public String deleteTask(@PathVariable int taskId) {

		return service.deleteTask(taskId);
	}

	@GetMapping("/getAll")
	public List<Task> getAllTasks() {
		return service.getAllTasks();
	}

	@PutMapping("/updateTask")
	public String updateTask(@RequestBody Task task) {
		return service.updateTask(task);
	}

	@GetMapping("/getById/{taskId}")
	public Task getTaskById(int taskId) {
		return service.getTaskById(taskId);
	}

}
