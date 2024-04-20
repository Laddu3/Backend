package com.mms.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.project.exceptions.NoSuchMedicineExistsException;
import com.mms.project.model.Medicine;
import com.mms.project.repo.MedicineRepository;
/**
 * This is used for writing business logics
 * 
 * @author  jeevanandham_r@hcl.com
 */
//Medicine Service implementation class 
@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	MedicineRepository medicineRepository; // injecting medicine repository into medicine service imp
	//fetching all medicines
	public Iterable<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	public Medicine saveMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	//updating a medicine details
	public String updateMedicine(Medicine medicine) {
        Medicine existMedicine = medicineRepository.findById(medicine.getMedicineId()).orElse(null);
        if (existMedicine == null)
            return " Medicine not exist";
        else {
            existMedicine.setMedicineName(medicine.getMedicineName());
            medicineRepository.save(existMedicine);
        }
		return "Medicine Updated Sucessfully";
	}
	//deleting  medicines from database
	public String deleteMedicine(Long id) {
		try {
			medicineRepository.deleteById(id);
			return " Medicine Deleted SucussFully";
		} catch (NoSuchMedicineExistsException e) {
			throw new NoSuchMedicineExistsException("No such hangar exists");// exceptionhandling for deleting medicine
		}
	}
}