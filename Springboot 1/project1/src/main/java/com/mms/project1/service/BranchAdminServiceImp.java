package com.mms.project1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.project1.model.BranchAdmin;
import com.mms.project1.repo.BranchAdminRepository;

@Service
public class BranchAdminServiceImp implements BranchAdminService {

	@Autowired
	BranchAdminRepository branchAdminRepo;

	@Override
	public String registration(BranchAdmin ba) {
		if(branchAdminRepo.save(ba).getBranchId()>0){

			return "Success";
		}
		return "Failed";

	}

	@Override
	public BranchAdmin login(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String updateBranchAdmin(BranchAdmin ba) {

		BranchAdmin existBranchAdmin =  branchAdminRepo.findById(ba.getBranchId()).orElse(null);
//findById(ba.getBranchId()).orElse(null);
		if (existBranchAdmin == null)

			return " BranchAdmin not exist";

		else {

			existBranchAdmin.setBranchName(ba.getBranchName());

			branchAdminRepo.save(existBranchAdmin);

		}

		return "BranchAdmin Updated Sucessfully";

	}

}
