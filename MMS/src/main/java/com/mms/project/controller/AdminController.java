package com.mms.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.project.exceptions.AdminNotFoundException;
import com.mms.project.model.Admin;
import com.mms.project.service.AdminService;

import lombok.extern.log4j.Log4j2;

/**
 * This is Admin controller class
 * 
 * 
 * @author mandala.kamalkishore@hcl.com
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
	@PostMapping("/registration")
	public String Register(@Valid @RequestBody Admin admin,BindingResult bindingResult) {
		adminService.registration(admin);
		return "Admin Successfully registred";
	}

	// admin login
	@PostMapping("/login")

	public ResponseEntity<String> loginByPath(@RequestBody Admin admin,BindingResult bindingResult) {
		try {
			log.info("Login is in progress..");

			Admin resultMember = adminService.login(admin.getEmail());
			if (resultMember != null)
				if (resultMember.getPassword().equals(admin.getPassword())) {
					log.info("Admin Login is success.");
					return new ResponseEntity<>("Success", HttpStatus.OK);
				}
			log.info("Login is failed.");
			return new ResponseEntity<>("Email/Password is incorrect.", HttpStatus.FORBIDDEN);
		} catch (AdminNotFoundException e) { // exceptionhandling for adminnotfound
			throw new IllegalStateException();
		}
	}

}
