package com.mms.project.service;

import com.mms.project.model.Medicine;
/**
 * This is used for writing business logics
 * 
 * @author Team 1
 */
//Medicine Service Interface 
public interface MedicineService {
	//fetching all medicines
	public Iterable<Medicine> getAllMedicines();
	public Medicine saveMedicine(Medicine medicine);
	//updating a medicine details
	public String updateMedicine(Medicine medicine);
	//deleting  medicines from database
	public String deleteMedicine(Long id);
}
