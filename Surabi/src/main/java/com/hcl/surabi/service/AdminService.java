package com.hcl.surabi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.surabi.entity.Admin;
import com.hcl.surabi.entity.Item;
import com.hcl.surabi.entity.MyOrderHistory;
import com.hcl.surabi.entity.User;
import com.hcl.surabi.exceptions.AdminNotFoundException;
import com.hcl.surabi.repository.AdminRepository;
import com.hcl.surabi.repository.ItemRepository;
import com.hcl.surabi.repository.MyOrderHistoryRepository;
import com.hcl.surabi.repository.UserRepository;

@Service
public class AdminService {

	Admin admin = new Admin();

	@Autowired
	UserRepository userRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ItemRepository menuRepository;

	@Autowired
	MyOrderHistoryRepository myOrderHistoryRepository;

	public ResponseEntity<String> registerAdmin(Admin admin) {
		ResponseEntity<String> response = null;
		Admin a = adminRepository.save(admin);
		if (a != null) {
			response = new ResponseEntity<String>("User Registration Success", HttpStatus.ACCEPTED);

		} else {
			try {
				throw new AdminNotFoundException();
			} catch (AdminNotFoundException e) {

			}
		}
		{
			response = new ResponseEntity<String>("User Registration Failed!", HttpStatus.NOT_ACCEPTABLE);
		}
		return response;
	}

	// save admin
	public Admin saveadmin(Admin admin) {

		return adminRepository.save(admin);
	}

	// Login Admin
	public String loginAdmin(Admin admin) {

		// checking Login Condition
		if (adminRepository.findByAdminuserNameAndAdminpassword(admin.getAdminuserName(),
				admin.getAdminpassword()) != null) {
			return "Admin sucessfully logged in";
			}
		try 
		{
            throw new AdminNotFoundException();
        } catch (AdminNotFoundException e) {
            System.err.println("admin not found");
        }
        return " Sorry..! Invalid Credentials";
}

	// Logout Admin
	public String logoutAdmin(Admin admin) {

		// checking Logout Condition
		if (adminRepository.findByAdminuserNameAndAdminpassword(admin.getAdminuserName(),
				admin.getAdminpassword()) != null) {
			return "Admin sucessfully log out";
		} else {

			return "admin details";

		}
	}	
	// CRUD operations on creating,deleting,displaying,updating user

	public User saveuser(User newuser) {

		return userRepository.save(newuser);// saving the user

	}

	public List<User> Displayallusers() {

		return userRepository.findAll();// displays all users
	}

	public void deleteuser(Long id) {

		userRepository.deleteById(id);// deleting user

	}

	public User Update(Long id, User users) {

		User user = userRepository.findById(id).get();
		user.setUserName(users.getUserName());
		user.setPassword(users.getPassword());

		return userRepository.save(user);
	}

	// admin performed some basic operations

	// displays bills generated today
	public List<MyOrderHistory> Showallbillstoday(LocalDate ld) {

		return myOrderHistoryRepository.findByDate(ld);
	}

	// displays user bills
	public List<MyOrderHistory> UserBill(String uname) {
		return myOrderHistoryRepository.findByUserName(uname);
	}

	// displaying all bills generated this month
	public List<MyOrderHistory> ShowallbillsMonthly() {

		return myOrderHistoryRepository.totalMonthlyBills();
	}

	// displays total sale amount in this month
	public String totalMonthlybill() {

		List<MyOrderHistory> list = myOrderHistoryRepository.findAll();
		int sum = 0;

		for (MyOrderHistory order : list) {
			sum = sum + order.getTotal_amt();
		}

		return "Total monthly amount : " + sum;
	}

	// CRUD operations on creating,deleting,displaying,updating menu items

	public Item saveitem(Item newitem) {
		return menuRepository.save(newitem);

	}

	public void deleteitem(Long id) {

		menuRepository.deleteById(id);

	}

	public List<Item> ShowallItems() {

		return menuRepository.findAll();
	}

	public Item Update(Long id, Item menus) {

		Item menu = menuRepository.findById(id).get();

		menu.setItemName(menus.getItemName());
		menu.setPrice(menus.getPrice());
		return menuRepository.save(menu);
	}

}
