package com.jpa.o2mdemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.o2mdemo.model.Exam;
@Repository
public interface ExamRepository extends CrudRepository<Exam, Integer> {

}
