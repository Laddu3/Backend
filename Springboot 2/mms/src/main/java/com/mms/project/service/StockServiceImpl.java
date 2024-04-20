package com.mms.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mms.project.model.Medicine;
import com.mms.project.repo.AdminRepository;
import com.mms.project.repo.StockRepository;
/**
 * This is used for writing business logics
 * 
 * @author Team 1
 */
//Stock Service implementation class 
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository; // injecting stock repository into stock service imp
	//fetching all medicines 
	public List<Medicine> getAllMedicines() {
	return stockRepository.findAll();
	}
	//updating stock details
	public void updateStockDetails(List<Medicine> medicines) {
	stockRepository.saveAll(medicines);
	}	
}