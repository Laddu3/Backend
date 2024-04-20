package com.hcl.task.service;

import java.util.List;

import com.hcl.task.entity.TaskEntity;

public interface TaskService {
	
	public TaskEntity addTask(TaskEntity task);
	public List<TaskEntity> getTask();
	public TaskEntity updateTask(Integer id, TaskEntity task);
	public void deleteTask(Integer id);
	public TaskEntity getTaskbyId(Integer id);
	
}
