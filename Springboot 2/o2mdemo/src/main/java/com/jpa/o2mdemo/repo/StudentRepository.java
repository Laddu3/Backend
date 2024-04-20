package com.jpa.o2mdemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.o2mdemo.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
