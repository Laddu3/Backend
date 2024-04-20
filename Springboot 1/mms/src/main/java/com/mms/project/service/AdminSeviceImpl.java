package com.mms.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.project.model.Admin;
import com.mms.project.repo.AdminRepository;

/**
 * This is used for writing business logics
 * 
 * @author  mandala.kamalkishore@hcl.com
 */
//AdminService implementation class 

@Service
public class AdminSeviceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo; // injecting adminrepository into adminserviceimp

	// admin registration
	@Override
	public String registration(Admin admin) {
		if (adminRepo.save(admin).getAdminId() > 0) {
			return "Registration Success";
		}
		return "Registration Failed";
	}
	
	// admin login
	@Override
	public Admin login(String name) {
		return adminRepo.getByEmail(name);
	}

}
