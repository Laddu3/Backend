package com.mms.project1.service;

import com.mms.project1.model.BranchAdmin;
import com.mms.project1.repo.BranchAdminRepository;

public interface BranchAdminService {
	public String registration(BranchAdmin ba);

	public BranchAdmin login(String email);

	public String updateBranchAdmin(BranchAdmin ba);
}
