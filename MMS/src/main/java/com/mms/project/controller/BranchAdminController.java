package com.mms.project.controller;

import java.util.List;

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

import com.mms.project.model.BranchAdmin;
import com.mms.project.service.BranchAdminService;

import lombok.extern.log4j.Log4j2;

/**
 * This is Branch Admin controller class
 * 
 * 
 * @author palagiriharsh.reddy@hcl.com
 *		   santhanam.r@hcl.com
 */

@RestController
@RequestMapping("/mms")
@Log4j2
public class BranchAdminController {

	@Autowired
	BranchAdminService branchAdminService;
	
	

	// Controller methods for branch admin
	// fetching Branch Admin by id
	@GetMapping("/branchadmin/{id}")
	public ResponseEntity<BranchAdmin> getBranchAdminById(@PathVariable Long id,BindingResult bindingResult) {
		log.info("fetching Branch Admin by id");
		BranchAdmin branchAdmin = branchAdminService.getBranchAdminById(id);
		return ResponseEntity.ok(branchAdmin);
	}

	// Fetching all branch admins
	@GetMapping("/allbranchadmins")
	public ResponseEntity<List<BranchAdmin>> getAllBranchAdmins() {
		log.info("Fetching all branch admins");
		List<BranchAdmin> branchAdmins = branchAdminService.getAllBranchAdmins();
		return ResponseEntity.ok(branchAdmins);
	}
	// Creating Branch Admin

	@PostMapping("/branchadmin")

	public ResponseEntity<BranchAdmin> createBranchAdmin(@RequestBody BranchAdmin branchAdmin,BindingResult bindingResult) {

		log.info("adding Branch Admin");

		BranchAdmin createdAdmin = branchAdminService.createBranchAdmin(branchAdmin);

		return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);

	}

	// Updating Branch Admin
	@PutMapping("/branchadmin")
	public String updateBranchAdmin(@RequestBody BranchAdmin branchAdmin,BindingResult bindingResult) {
		log.info("Updating Branch Admin");		
		BranchAdmin updatedAdmin = branchAdminService.updateBranchAdmin(branchAdmin);
		ResponseEntity.ok(updatedAdmin);
		return "BranchAdmin Updated Sucessfully";
	}

	// deleting Branch Admin by id
	@DeleteMapping("/branchadmin/{id}")
	public String deleteBranchAdmin(@PathVariable Long id,BindingResult bindingResult) {
		log.info("deleting Branch Admin by id");
		branchAdminService.deleteBranchAdmin(id);
		ResponseEntity.noContent().build();
		return "BranchAdmin Deleted Successfully";
	}
	
	
	 //Creating requesting for Medicine
	@PostMapping("/createrequest")
	 public ResponseEntity<String> createRequest(int quantity, @RequestBody BranchAdmin request,BindingResult bindingResult) {
	log.info("Creating requesting");
	branchAdminService.saveRequest(request, quantity);
	// Return a success response
	return ResponseEntity.ok("Your details are submitted successfully.");
	}
}
