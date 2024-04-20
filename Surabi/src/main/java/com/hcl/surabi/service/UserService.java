package com.hcl.surabi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.surabi.entity.Item;
import com.hcl.surabi.entity.MyOrderHistory;
import com.hcl.surabi.entity.User;
import com.hcl.surabi.exceptions.UserNotFoundException;
import com.hcl.surabi.repository.ItemRepository;
import com.hcl.surabi.repository.MyOrderHistoryRepository;
import com.hcl.surabi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ItemRepository menuRepository;

	@Autowired
	MyOrderHistoryRepository myOrderHistoryRepository;

	List<Item> stores = new ArrayList<Item>();
	LocalDate ld = LocalDate.now();

	public ResponseEntity<String> registerUser(User user) {
		ResponseEntity<String> response = null;
		User u = userRepository.save(user);
		if (u != null) {
			response = new ResponseEntity<String>("User Registration Success", HttpStatus.ACCEPTED);

		} else {
			try {
				throw new UserNotFoundException();
			} catch (UserNotFoundException e) {

			}
		}
		{
			response = new ResponseEntity<String>("User Registration Failed!", HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	// save user
	public User saveuser(User newuser) {

		return userRepository.save(newuser);

	}
	// Login for User
	public String loginUser(User user) {

		if (userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()) != null) {
			return "User sucessfully logged in";
		}

		try {
			throw new UserNotFoundException();

		} catch (UserNotFoundException e) {
			System.err.println("user not found");
		}

		return "Sorry..! Invalid Credentials ";
	}

	// Logout for user
	public String logoutUser(User user) {

		if (userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()) != null) {
			return "User sucessfully log out";
		} else {

			return "Incorrect user details";

		}
	}

	// shows all items in menu
	public List<Item> Showall() {
		return menuRepository.findAll();
	}

	/*
	 * // taking order from user public String searchItem(MyOrderHistory
	 * order_history) { int sum = 0; Item menu =
	 * menuRepository.findByItemName(order_history.getItemName());
	 * 
	 * MyOrderHistory history = new MyOrderHistory(); double price =
	 * menu.getPrice(); sum = price * order_history.getPlates();
	 * history.setItemName(order_history.getItemName()); history.setTotal_amt(sum);
	 * history.setUserName(order_history.getUserName());
	 * history.setPlates(order_history.getPlates()); history.setDate(ld);
	 * 
	 * myOrderHistoryRepository.save(history); return "total amount: " + sum; }
	 */

	// displays perticular user orders
	public List<MyOrderHistory> UserOrders(String username) {
		return myOrderHistoryRepository.findByUserName(username);
	}

	// adding items to store
	public List<Item> addToStore(String itemname) {

		Item store = menuRepository.findByItemName(itemname);

		stores.add(store);

		return stores;
	}

	// displays final bill of the user
	public String finalBill(String uname) {

		List<MyOrderHistory> history = myOrderHistoryRepository.findByUserName(uname);
		LocalDate ld = LocalDate.now();
		int sum = 0;
		for (MyOrderHistory order : history) {
			if (ld.equals(order.getDate())) {
				sum = sum + order.getTotal_amt();
			}
		}
		return "final Bill: " + sum;
	}

}
