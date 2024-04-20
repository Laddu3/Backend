package com.gl.capstone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.capstone.entity.VehicleEntity;

public interface VehicleRepo extends JpaRepository<VehicleEntity, Integer>{
	
	///////to get the price sorted data in vehicle from database
	
	@Query("From VehicleEntity ORDER BY price ASC")
	public List<VehicleEntity> PriceSort();

}
