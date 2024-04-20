package com.hcl.task.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.task.entity.Task;
import com.hcl.task.service.TaskService;


@RestController
@RequestMapping("/Task") 
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

	@Autowired
	TaskService taskService;

	
	@PostMapping("/Add Task")
	public String registerTask(@RequestBody Task task) {
		taskService.savetask(task);
		return "Task Added Successfully";
	}

	
	@GetMapping("/Display Tasks")
	public List<Task> Displayalltasks() {
		return taskService.Displayalltasks();
	}

	@PutMapping("/Update Task")
	public String updateTask(@RequestBody Task task) {
	   taskService.Update(task);
	   return "Task Updated successfully";
	}
	
	@DeleteMapping("/delete/{id}") //to delete the data from database
	public String deleteTask(@PathVariable (value="id") Integer id)
	{
		taskService.deleteTask(id);
		return "Task deleted successfully";
	}
	
}
		