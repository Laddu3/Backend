package com.gl.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.capstone.entity.OwnerMsgs;
@Repository  //to perform crud operations
public interface OwnerMsgRepo extends JpaRepository<OwnerMsgs	, Integer>{

}
