package com.gl.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.capstone.entity.WaitingApprove;
@Repository   //to perform crud operations
public interface WaitingApproveRepo extends JpaRepository<WaitingApprove,Integer>{

}
