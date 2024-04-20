package com.task.taskmanager.service;

import java.util.List;

import com.task.taskmanager.entity.Task;

public interface TaskService {

	
	public String addTask(Task task);
	
	public String deleteTask(int taskId);
	
	public List<Task> getAllTasks();
	
	public String updateTask(Task task);
	
	public Task getTaskById(int taskId);
}
