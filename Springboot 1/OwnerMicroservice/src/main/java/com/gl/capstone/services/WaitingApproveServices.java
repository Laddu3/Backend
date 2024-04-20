package com.gl.capstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.capstone.entity.WaitingApprove;
import com.gl.capstone.repo.WaitingApproveRepo;

@Service  //for business logic

public class WaitingApproveServices {

	@Autowired //used to inject the object dependency implicitly
	WaitingApproveRepo waitingApproveRepo;
	//to add the approve data into database 

	public WaitingApprove addVehicle(WaitingApprove task) {

		return waitingApproveRepo.save(task);
	}
	//to retrieve the approve data from database
	public List<WaitingApprove> getVehicles() {

		return waitingApproveRepo.findAll();
	}
	//to delete the approve data into database by id
	public void deleteVehicle(Integer id) {

		waitingApproveRepo.deleteById(id);

	}
	//to retrieve the approve data into database by id
	public WaitingApprove getVehicleById(Integer id) {
		
		return waitingApproveRepo.findById(id).get();
	}

}
