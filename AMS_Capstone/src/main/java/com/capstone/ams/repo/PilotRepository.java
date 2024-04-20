package com.capstone.ams.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.ams.model.Pilot;
/**
 * 
 * 
 * @author kurapati.kavyasree@hcl.com
 * 
 */

//PilotRepository
@Repository
public interface PilotRepository extends JpaRepository<Pilot, Long> {

}
