package com.hcl.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.task.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer>{

}
