package com.gl.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.capstone.entity.UserMessages;
import com.gl.capstone.services.UserMsgService;

@RestController // It is used for making restful web services
@RequestMapping("/umessage") // used to map web requests
@CrossOrigin(origins = "http://localhost:3000") // used to connect frontend and backend

public class UserMsgController {

	@Autowired // used to inject the object dependency implicitly
	UserMsgService userMsgService;

	@PostMapping("/insert") /// to insert the data into database
	public String AddMsg(@RequestBody UserMessages msg) {
		userMsgService.addMessages(msg);
		return "Message Added Successfully";
	}

	@GetMapping("/messages") // to retrieve the data from database
	public List<UserMessages> getMsgs() {
		return userMsgService.getMessages();
	}

	@GetMapping("/messages/{id}") ////// to retrieve the data using id
	public UserMessages getMsgbyId(@PathVariable(value = "id") Integer id) /// @pathvariable used to extract values
	{
		return userMsgService.getMessagebyId(id);
	}

}
