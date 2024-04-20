package com.hcl.surabi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.surabi.entity.Item;
import com.hcl.surabi.entity.MyOrderHistory;
import com.hcl.surabi.entity.User;
import com.hcl.surabi.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	UserService userService;

	// User Registration
	@PostMapping("/Register")
	public String registerUser(@RequestBody User newuser) {
		userService.saveuser(newuser);
		return "User Registered Successfully";
	}

	// Login User
	@PostMapping("/Login")
	public String userLogin(@RequestBody User user) {
		return userService.loginUser(user);
	}

	// Logout user
	@PostMapping("/Logout")
	public String userLogOut(@RequestBody User user) {
		return userService.logoutUser(user);
	}

	// Displays All Menu Items
	@GetMapping("/Display menu")
	public List<Item> Showall() {
		return userService.Showall();
	}
	
	// Adding that itemdetails to store
	@PostMapping("/Item detail/{itemname}")
	public List<Item> addToStore(@PathVariable(value = "itemname") String itemname) {
		return userService.addToStore(itemname);
	}

	// For Ordering the item
	/*
	 * @PostMapping("/Order") public String SearchItem(@RequestBody MyOrderHistory
	 * order_history) { return userService.searchItem(order_history); }
	 */

	// Displays all orders by username
	@GetMapping("/Order history/{username}")
	public List<MyOrderHistory> UserOrders(@PathVariable(value = "username") String username) {
		return userService.UserOrders(username);
	}
	// Final Total Bill for  user
		@GetMapping("/Total lbill/{username}")
		public String finalBill(@PathVariable(value = "username") String username) {
			return userService.finalBill(username);
		}
	

}
