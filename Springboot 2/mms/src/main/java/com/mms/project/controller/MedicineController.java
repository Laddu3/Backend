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

import com.mms.project.model.Medicine;
import com.mms.project.service.MedicineService;
import com.mms.project.service.StockServiceImpl;

import lombok.extern.log4j.Log4j2;

/**
 * This is Medicine controller class

 * 
 * @author Team 1
 * 
 *
 */

@RestController
@RequestMapping("/mms")
@Log4j2
public class MedicineController {

	@Autowired
	MedicineService medicineService;

	@Autowired
	StockServiceImpl stockService;
	// Controller methods for Medicine
	//creating medicines
	  
	//Updating Medicines
	@PutMapping("/updatemedicine")
	public String updateMedicine(@RequestBody Medicine medicine) {
		log.info("Updating Medicines");
		medicineService.updateMedicine(medicine);
		return "Medicine Updated successfully";
	}
	//deleting medicine by id
	@DeleteMapping("/deletemedicine/{id}")
	public String deleteMedicine(@PathVariable(value = "id") Long id) {
		log.info("deleting medicine by id");
		medicineService.deleteMedicine(id);
		return "Medicine deleted successfully";
	}
	//getting all medicine stock details
	@GetMapping("/stock-details")
	public String getStockDetails() {
		log.info("getting all medicine stock details");
		stockService.getAllMedicines();
		return "fetched stock details successfully";
	}
	//medicine bulk updates
	@PutMapping("/bulk-update")
	public ResponseEntity<String> bulkUpdateStock(@RequestBody List<Medicine> medicines) {
		log.info("bulk update");
		try {
			stockService.updateStockDetails(medicines);
			log.info("Your bulk updates have been submitted successfully.");
			return ResponseEntity.ok("Your bulk updates have been submitted successfully.");
		} catch (Exception e) {
			log.info("Your bulk updates failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Your bulk updates failed - details are " + e.getMessage());
		}
	}
}
