package com.mms.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mms.project.model.Medicine;

/**
 * 
 * 
 * @author Team 1
 * 
 */

//Medicine Repository

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}