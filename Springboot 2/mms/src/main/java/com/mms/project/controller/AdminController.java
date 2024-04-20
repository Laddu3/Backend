package com.mms.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.project.model.Admin;
import com.mms.project.service.AdminService;

import lombok.extern.log4j.Log4j2;

/**
 * This is Admin controller class

 * 
 * @author Team 1
 * 
 *
 */

@RestController
@RequestMapping("/mms")
@Log4j2
public class AdminController {

	@Autowired
	AdminService adminService;
	
    // Controller methods for admin
	// admin registration
	@PostMapping("/adminregistration")
	public String registration(@Valid @RequestBody Admin admin) {
		log.info("Registration is in progress..");
		return adminService.registration(admin);
	}
	//admin login
	@PostMapping("/adminlogin")
	public String loginByPath(@RequestBody Admin admin) {
		log.info("Login is in progress..");
		Admin resultMember = adminService.login(admin.getEmail());
		if (resultMember != null && resultMember.getPassword().equals(admin.getPassword())) {
			log.info("Login is success.");
			return "Login Success";
		}
		log.info("Login is failed.");
		return "Email/Password is incorrect.";
	}
}
