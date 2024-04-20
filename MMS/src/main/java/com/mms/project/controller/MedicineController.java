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

import com.mms.project.model.Medicine;
import com.mms.project.service.MedicineService;
import com.mms.project.service.StockServiceImpl;

import lombok.extern.log4j.Log4j2;

/**
 * This is Medicine controller class

 * 
 * @author  jeevanandham_r@hcl.com
 * 		    santhanam.r@hcl.com
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
	@PostMapping("/medicine")
	public String saveMedicine(@RequestBody Medicine medicine,BindingResult bindingResult) {
		log.info("creating medicines");
		medicineService.saveMedicine(medicine);
		return "Medicine Added Successfully";
	}
	//Updating Medicines
	@PutMapping("/medicine")
	public String updateMedicine(@RequestBody Medicine medicine,BindingResult bindingResult) {
		log.info("Updating Medicines");
		medicineService.updateMedicine(medicine);
		return "Medicine Updated Successfully";
	}
	//deleting medicine by id
	@DeleteMapping("/medicine/{id}")
	public String deleteMedicine(@PathVariable(value = "id") Long id,BindingResult bindingResult) {
		log.info("deleting medicine by id");
		medicineService.deleteMedicine(id);
		return "Medicine deleted successfully";
	}
	//getting all medicine stock details
	@GetMapping("/stockdetails")
	public List<Medicine> getStockDetails() {
		log.info("getting all medicine stock details");
		return stockService.getAllMedicines();
	}
	//medicine bulk updates
	@PutMapping("/bulkupdate")
	public ResponseEntity<String> bulkUpdateStock(@RequestBody List<Medicine> medicines,BindingResult bindingResult) {
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
