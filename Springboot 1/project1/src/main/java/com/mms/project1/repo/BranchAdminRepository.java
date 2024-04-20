package com.mms.project1.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mms.project1.model.BranchAdmin;

@Repository
public interface BranchAdminRepository extends JpaRepository<BranchAdmin, Integer>{

	public BranchAdmin getByEmail(String email);

	public Optional<BranchAdmin> findById(long branchId);
	
}
