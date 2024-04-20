package com.hcl.surabi.service;

import org.springframework.http.ResponseEntity;

import com.hcl.surabi.entity.Admin;

public interface IAdminService {
	public ResponseEntity<String> registerAdmin(Admin admin);

	public Admin getAdminByAdminName(String adminName);

}