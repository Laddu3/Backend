package com.capstone.ams.controller;

/**
 * This is Admincontroller class

 * 
 * @author jakkula.ramesh@hcl.com
 *         manneusha.sri@hcl.com
 *         kurapati.kavyasree@hcl.com
 *         ramasrujana.meka@hcl.com
 * 
 *
 */
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.ams.exception.AdminNotFoundException;
import com.capstone.ams.model.Admin;
import com.capstone.ams.model.Hangar;
import com.capstone.ams.model.Pilot;
import com.capstone.ams.model.Plane;
import com.capstone.ams.service.AdminService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/ams")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

//registration details
	@PostMapping("/adminregistration")
	/*
	 * public String registration(@Valid @RequestBody Admin admin) {
	 * log.info("Registration is in progress.."); return
	 * adminService.registration(admin); }
	 */
	public ResponseEntity<String> registration(@Valid @RequestBody Admin admin, BindingResult result) {
		log.info("Registration is in progress..");
		if (result.hasErrors()) {
			return new ResponseEntity<>(result.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		String s = adminService.registration(admin);
		if (s.contains("Success")) {
			return new ResponseEntity<>(s, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	// login details
	@PostMapping("/adminlogin")
	/*
	 * public String loginByPath(@RequestBody Admin admin) {
	 * log.info("Login is in progress.."); Admin resultMember =
	 * adminService.login(admin.getEmail()); if (resultMember != null &&
	 * resultMember.getPassword().equals(admin.getPassword())) {
	 * log.info("Login is success."); return "Success"; }
	 * log.info("Login is failed."); return "Email/Password is incorrect."; }
	 */
	public ResponseEntity<String> loginByPath(@RequestBody Admin admin) {
		try {
			log.info("Login is in progress..");
			Admin resultMember = adminService.login(admin.getEmail());
			if (resultMember.getPassword().equals(admin.getPassword())) {
				log.info("Login is success.");
				return new ResponseEntity<>("Success", HttpStatus.OK);
			}
			log.info("Login is failed.");
			return new ResponseEntity<>("Email/Password is incorrect.", HttpStatus.FORBIDDEN);
		} catch (AdminNotFoundException e) {
			throw new IllegalStateException();
		}
	}

	// Controller methods for Plane details
	// adding palne details as an admin
	@PostMapping("/addplane")
	public String addPlane(@RequestBody Plane plane) {
		log.info("addplane is in progress..");
		return adminService.addPlane(plane);
	}

	// getting all planes details
	@GetMapping("/getallplanes")
	public List<Plane> getAllPlanes() {
		log.info("getplane info is in progress..");
		return adminService.getAllPlanes();
	}

	// deleteing plane details by planeId as an admin
	@DeleteMapping("/delete/{planeId}")
	public String deletePlane(@PathVariable Long planeId) {
		log.info("delete plane is in progress..");
		return adminService.deletePlane(planeId);
	}

	// updating plane details as an admin
	@PutMapping("/updateplanedetails")
	public String updatePlane(@RequestBody Plane plane) {
		log.info("update is in progress..");
		return adminService.updatePlane(plane);
	}

	// Controller methods for Pilot details
	// adding piolt details as an admin
	@PostMapping("/addpilot")
	public String addPilot(@RequestBody Pilot pilot) {
		log.info("addpilot is in progress..");
		return adminService.addPilot(pilot);
	}

	// getting all pilot details
	@GetMapping("/getallpilots")
	public List<Pilot> getAllPilots() {
		log.info("getallpilots is in progress..");
		return adminService.getAllPilots();
	}

	// deleting pilot details by pilotId as an admin
	@DeleteMapping("/deletepilot/{pilotId}")
	public String deletePilot(@PathVariable Long pilotId) {
		log.info("delete pilot details is in progress..");
		return adminService.deletePilot(pilotId);
	}

	// updating pilot detalis as an admin
	@PutMapping("/updatepilotdetails")
	public String updatePilot(@RequestBody Pilot pilot) {
		log.info("update pilot details is in progress..");
		return adminService.updatePilot(pilot);
	}

	// Controller methods for hangar details
	// adding hangar as an admin
	@PostMapping("/addhangar")
	public String addHangar(@RequestBody Hangar hangar) {
		log.info("Add hanger is in progress..");
		return adminService.addHangar(hangar);

	}

	// deleting hangar details by hangarId as an admin
	@DeleteMapping("/deletehangar/{hangarId}")
	public String deleteHangar(@PathVariable Long hangarId) {
		log.info("Delete hanger is in progress..");
		return adminService.deleteHangar(hangarId);
	}

	// getting all hangar details
	@GetMapping("/getallhangars")
	public List<Hangar> getAllHangar() {
		log.info("Hangers info is in progress..");
		return adminService.getAllHangar();
	}

	// updating all hanger details as an admin
	@PutMapping("/updatehangardetails")
	public String updateHangar(@RequestBody Hangar hangar) {
		log.info("Hanger update is in progress..");
		return adminService.updateHangar(hangar);
	}

	// getting hangar details by hangarId as an admin
	@GetMapping("/gethangar/{hangarId}")
	public Hangar getHangarById(@PathVariable Long hangarId) {
		log.info("getting hanger details is in progress..");
		return adminService.getHangarById(hangarId);
	}
}
