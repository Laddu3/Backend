package com.mms.project.service;

import java.util.List;

import com.mms.project.model.BranchAdmin;

/**
 * This is used for writing business logics
 * 
 * @author palagiriharsh.reddy@hcl.com
 */
//Branch Admin Service Interface 
public interface BranchAdminService {
	//fetching branch admin by id
	public BranchAdmin getBranchAdminById(Long id);
	//fetching all branch admins
	public List<BranchAdmin> getAllBranchAdmins();
	//creating branch admin
	public BranchAdmin createBranchAdmin(BranchAdmin branchAdmin);
	//updating branch admin
	public BranchAdmin updateBranchAdmin(BranchAdmin branchAdmin);
	//deleting branch admin
	public String deleteBranchAdmin(Long id);
	public void saveRequest(BranchAdmin request, int quantity);
	
}
