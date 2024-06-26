package com.mms.project.service;

import java.util.List;

import com.mms.project.model.Medicine;
/**
 * This is used for writing business logics
 * 
 * @author  santhanam.r@hcl.com
 */

//Stock Service Interface 
public interface StockService {
	//fetching all medicines 
	public List<Medicine> getAllMedicines();
	//updating stock details
	public void updateStockDetails(List<Medicine> medicines);
}
