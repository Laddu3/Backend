package com.gl.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.capstone.entity.UserEntity;
import com.gl.capstone.services.UserServices;

@RestController  //It is used for making restful web services

@RequestMapping("/user")   //used to map web requests 

@CrossOrigin(origins="http://localhost:3000")    // used to connect backend and frontend


public class UserController {
	
	@Autowired  //used to inject the object dependency implicitly
	UserServices userServices;
	
	@PostMapping("/insert")   //to insert user data into database
	public String AddOwner(@RequestBody UserEntity user)
	{
		userServices.addUser(user);
		return "User Added Successfully";
	}
	@GetMapping("/users")     //to retrieve the user data from database
	public List<UserEntity> getOwners()
	{
		return userServices.getUsers();
	}
	@PutMapping("/update/{id}")   //to update the user data in database
	public String updateUser(@PathVariable (value="id") Integer id,@RequestBody UserEntity user)
	{
		userServices.updateUser(id,user);
		return "updated successfully";
	}
	@DeleteMapping("/delete/{id}")    //to delete the user data from database
	public String deleteOwner(@PathVariable (value="id") Integer id)
	{
		userServices.deleteUser(id);
		return "deleted successfully";
	}
	

}
