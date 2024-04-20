package com.mms.project1.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.project1.model.BranchAdmin;
import com.mms.project1.service.BranchAdminService;


import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/mms")
@RestController
public class BranchAdminController {

	private BranchAdminService branchAdminService;

	@PostMapping("/branchadminregistration")
	public ResponseEntity<String> registration(@Valid @RequestBody BranchAdmin ba, BindingResult result) {
		log.info("Registration is in progress..");
		if (result.hasErrors()) {
			log.info("Registration is failed.");
			return new ResponseEntity<>(result.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		String s = branchAdminService.registration(ba);
		if (s.contains("Success")) {
			return new ResponseEntity<>(s, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginByPath(@RequestBody BranchAdmin ba) {
        try {
            log.info("Login is in progress..");
            BranchAdmin resultBranchAdmin = branchAdminService.login(ba.getEmail());
            if (resultBranchAdmin.getPassword().equals(ba.getPassword())) {
                log.info("Login is success.");
                return new ResponseEntity<>("Success", HttpStatus.OK);
            }
            log.info("Login is failed.");
            return new ResponseEntity<>("Email/Password is incorrect.", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
	@GetMapping("/login/{email}/{pwd}")
	public String loginByPath(@PathVariable("email") String e, @PathVariable("pwd") String p) {
		BranchAdmin resultBranchAdmin = branchAdminService.login(e);
		if (resultBranchAdmin != null) {
			if (resultBranchAdmin.getPassword().equals(p)) {
				return "Success";
			}
		}
		return "Email/Password is incorrect.";
	}
	@PutMapping("/update")

    public String updateBranchAdmin(@RequestBody BranchAdmin ba) {

        return branchAdminService.updateBranchAdmin(ba);

    }
	}

