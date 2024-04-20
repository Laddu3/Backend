package com.mms.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mms.project.model.Medicine;

/**
 * 
 * 
 * @author santhanam.r@hcl.com
 * 
 */

//StockAdmin Repository
@Repository
public interface StockRepository extends JpaRepository<Medicine, Long> {

}
