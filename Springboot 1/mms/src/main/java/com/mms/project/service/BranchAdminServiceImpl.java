package com.mms.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.project.exceptions.NoSuchBranchAdminExistsException;
import com.mms.project.model.BranchAdmin;
import com.mms.project.model.Medicine;
import com.mms.project.repo.BranchAdminRepository;

/**
 * This is used for writing business logics
 * 
 * @author palagiriharsh.reddy@hcl.com
 */
//AdminBranch Service implementation class 
@Service
public class BranchAdminServiceImpl implements BranchAdminService{
	
	@Autowired
	BranchAdminRepository branchAdminRepository; // injecting branchadmin repository into branchadmin serviceimp

	
	public BranchAdminServiceImpl(BranchAdminRepository branchAdminRepository) {
		this.branchAdminRepository = branchAdminRepository;
	}
	//fetching branch admin by id
	public BranchAdmin getBranchAdminById(Long id) {
		return branchAdminRepository.findById(id).orElseThrow(null);
	}
	//fetching all branch admins
	public List<BranchAdmin> getAllBranchAdmins() {
		return branchAdminRepository.findAll();
	}
	//creating branch admin
	public BranchAdmin createBranchAdmin(BranchAdmin branchAdmin) {
        return branchAdminRepository.save(branchAdmin);
        }
	//updating branch admin
	public BranchAdmin updateBranchAdmin(BranchAdmin branchAdmin) {
		BranchAdmin existBranchAdmin = branchAdminRepository.findById(branchAdmin.getBranchId()).orElse(null);
		if (existBranchAdmin == null) {
			throw new NoSuchBranchAdminExistsException("No such Branch Admin exists!");// exception handling for updating branch Admin
		}
		try {
			existBranchAdmin.setBranchName(branchAdmin.getBranchName());
			branchAdminRepository.save(existBranchAdmin);
		} catch (NoSuchBranchAdminExistsException e) {
			throw new NoSuchBranchAdminExistsException("No such branch admin exists!");
	}
		return existBranchAdmin;
}

	//deleting branch admin
	public String deleteBranchAdmin(Long id) {
		try {
			branchAdminRepository.deleteById(id);
			return " Branch admin Deleted SucussFully";
		}
		catch (NoSuchBranchAdminExistsException e) {
			throw new NoSuchBranchAdminExistsException("No such branch admin exists");// exceptionhandling for deleting branch admin
		}
	}

	public void saveRequest(BranchAdmin request, int quantity) {
	request.setQuantity(quantity);
	branchAdminRepository.save(request);
	}
	
}