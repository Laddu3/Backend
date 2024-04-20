package com.mms.project.service;


import com.mms.project.model.Admin;

/**
 * This is used for writing business logics
 * 
 * @author  mandala.kamalkishore@hcl.com
 */

//AdminService Interface 
public interface AdminService {
	//admin registration
	public String registration(Admin admin);
	
	//admin login
	public Admin login(String email);
}
