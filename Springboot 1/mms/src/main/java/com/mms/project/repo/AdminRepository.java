package com.mms.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mms.project.model.Admin;

/**
 * 
 * 
 * @author  mandala.kamalkishore@hcl.com
 * 
 */

//Admin Repository

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	public Admin getByEmail(String email);

	// This is only for explanation do not send password via method parameters
	public Admin findByEmailAndPassword(String email, String password);

	public Admin findByEmail(String email);
}
