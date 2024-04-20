package com.gl.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.capstone.entity.MyBookings;
import com.gl.capstone.services.MyBookingServices;

@RestController             //It is used for making restful web services

@RequestMapping("/booking") //used to map web requests 

@CrossOrigin(origins="http://localhost:3000")  // used to connect backend and frontend


public class MyBookingController {
	@Autowired   //used to inject the object dependency implicitly
	MyBookingServices myBookingServices;
	///TO  ADD THE BOOKING DATA  
	@PostMapping("/insert")    //to insert the data into database
	public String AddBooking(@RequestBody MyBookings booking)
	{
		myBookingServices.addBooking(booking);
		return "User Added Successfully";
	}
	
	//TO GET ALL THE  BOOKING DETAILS
	@GetMapping("/bookings")  //to retrieve the data from database
	public List<MyBookings> getMyBookings()
	{
		return myBookingServices.getBookings();
	}
	
	/// TO GET THE BOOK DETAILS BY ID
	@GetMapping("/bookings/{id}")  //to retrieve the data from database
	public MyBookings getMyBookingbyId(@PathVariable(value="id") int id)
	{
		return myBookingServices.getBookingbyId(id);
	}
///TO DELETE THE BOOK DETAILS BY ID
	@DeleteMapping("/delete/{id}")   //to delete the data from database
	public String deleteBooking(@PathVariable (value="id") Integer id)
	{
		myBookingServices.deleteBooking(id);
		return "deleted successfully";
	}
	

}
