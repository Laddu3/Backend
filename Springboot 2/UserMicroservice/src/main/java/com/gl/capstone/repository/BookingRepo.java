package com.gl.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.capstone.entity.MyBookings;
@Repository //to perform crud operations
public interface BookingRepo extends JpaRepository<MyBookings, Integer>{

}
