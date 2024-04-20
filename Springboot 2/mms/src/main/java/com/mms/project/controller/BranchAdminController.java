package com.mms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.project.model.BranchAdmin;
import com.mms.project.service.BranchAdminService;

import lombok.extern.log4j.Log4j2;

/**
 * This is Branch Admin controller class

 * 
 * @author Team 1
 * 
 *
 */

@RestController
@RequestMapping("/mms")
@Log4j2
public class BranchAdminController {

	@Autowired
	BranchAdminService branchAdminService;
	// Controller methods for branch admin
	//fetching Branch Admin by id
	@GetMapping("/getBranchAdmin/{id}")
	public ResponseEntity<BranchAdmin> getBranchAdminById(@PathVariable Long id) {
		log.info("fetching Branch Admin by id");
		BranchAdmin branchAdmin = branchAdminService.getBranchAdminById(id);
		return ResponseEntity.ok(branchAdmin);
	}
	//Fetching all branch admins
	@GetMapping("/getAllBranchAdmins")
	public ResponseEntity<List<BranchAdmin>> getAllBranchAdmins() {
		log.info("Fetching all branch admins");
		List<BranchAdmin> branchAdmins = branchAdminService.getAllBranchAdmins();
		return ResponseEntity.ok(branchAdmins);
	}
	//Creating Branch Admin
	@PostMapping("/addBranchAdmin")
	public ResponseEntity<BranchAdmin> createBranchAdmin(@RequestBody BranchAdmin branchAdmin) {
		log.info("Creating Branch Admin");
		BranchAdmin createdAdmin = branchAdminService.createBranchAdmin(branchAdmin);
		return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
	}
	//Updating Branch Admin
	@PutMapping("/updateBranchAdmin/{id}")
	public ResponseEntity<BranchAdmin> updateBranchAdmin(@PathVariable Long id, @RequestBody BranchAdmin branchAdmin) {
		log.info("Updating Branch Admin");
		branchAdmin.setBranchId(id);
		BranchAdmin updatedAdmin = branchAdminService.updateBranchAdmin(branchAdmin);
		return ResponseEntity.ok(updatedAdmin);
	}
	//deleting Branch Admin by id
	@DeleteMapping("/deleteBranchAdmin/{id}")
	public ResponseEntity<Void> deleteBranchAdmin(@PathVariable Long id) {
		log.info("deleting Branch Admin by id");
		branchAdminService.deleteBranchAdmin(id);
		return ResponseEntity.noContent().build();
	}
	
	//Creating requesting
//	@PostMapping("/create-request")
//	public ResponseEntity<String> createRequest(@RequestParam("quantity") int quantity, @RequestBody BranchAdmin request) {
//	log.info("Creating requesting");
//	branchAdminService.saveRequest(request, quantity);
//	// Return a success response
//	return ResponseEntity.ok("Your details are submitted successfully.");
//	}
}
