package com.task.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.taskmanager.entity.Task;
import com.task.taskmanager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository repo;

	@Override
	public String addTask(Task task) {

		Task tas = new Task();
		tas.setTaskName(task.getTaskName());
		tas.setStartDate(task.getStartDate());
		tas.setEndDate(task.getEndDate());

		repo.save(tas);
		return "Task Added Sucusfully";
	}

	@Override
	public String deleteTask(int taskId) {
		repo.deleteById(taskId);
		return "Task Deleted SucussFully";
	}

	@Override
	public List<Task> getAllTasks() {
		return repo.findAll();
	}

	@Override
	public String updateTask(Task task) {
		Task exitTask = repo.findById(task.getTaskId()).orElse(null);
		exitTask.setTaskName(task.getTaskName());
		exitTask.setStartDate(task.getStartDate());
		exitTask.setEndDate(task.getEndDate());
		repo.save(exitTask);
		return "Updated SucussFully";
	}

	@Override
	public Task getTaskById(int taskId) {
		Optional<Task> tas = repo.findById(taskId);
		if (tas.isPresent()) {
			return tas.get();
		}
		return null;
	}
}