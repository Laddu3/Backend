package com.gl.capstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.capstone.entity.OwnerEntity;
import com.gl.capstone.repo.OwnerRepo;

@Service  //for business logic
public class OwnerServices {
	@Autowired  //used to inject the object dependency implicitly
	OwnerRepo ownerRepo;
	//to add owner the data into database
	public OwnerEntity addOwner(OwnerEntity owner)
	{
		
			return ownerRepo.save(owner);
	
		
	}
	//to retrieve the owner data into database 
	public List<OwnerEntity> getOwners() {
		
		return ownerRepo.findAll();
	}
	//to update the owner data into database by id
	public OwnerEntity updateOwner(Integer id, OwnerEntity owner) {
		OwnerEntity uowner=ownerRepo.findById(id).get();
		
		uowner.setOwnerName(owner.getOwnerName());
		uowner.setOwnerEmail(owner.getOwnerEmail());
		uowner.setOwnerPhone(owner.getOwnerPhone());
		uowner.setOwnerPassword(owner.getOwnerPassword());
		
		return ownerRepo.save(uowner);
		
		
	}
	//to delete the owner data into database by id
	public void deleteOwner(Integer id) {
		ownerRepo.deleteById(id);
		
	}

}
