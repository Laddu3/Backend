package com.hcl.surabi.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.surabi.entity.Admin;
import com.hcl.surabi.entity.Item;
import com.hcl.surabi.entity.MyOrderHistory;
import com.hcl.surabi.entity.User;
import com.hcl.surabi.service.AdminService;

@RestController
@RequestMapping("/Admin") 
public class AdminController {

	@Autowired
	AdminService adminService;

	
	@PostMapping("/SignUp")
	public String registerAdmin(@RequestBody Admin admin) {
		adminService.saveadmin(admin);
		return "Admin Registered Successfully";
	}

	// Admin Login
	@PostMapping("/Login")
	public String adminLogin(@RequestBody Admin admin) {
		return adminService.loginAdmin(admin);
	}

	// Admin Logout
	@PostMapping("/Logout")
	public String adminLogout(@RequestBody Admin admin) {
		return adminService.logoutAdmin(admin);
	}

	// Admin CRUD Operations on creating a User,display all users,delete and update user by id

	
	@PostMapping("/AddUser")
	public String registerUser(@RequestBody User newuser) {
		adminService.saveuser(newuser);
		return "User Registered Successfully";
	}

	
	@GetMapping("/DisplayUsers")
	public List<User> Displayallusers() {
		return adminService.Displayallusers();
	}

	@DeleteMapping("/DeleteUser/{uid}")
	private String deleteUser(@PathVariable(value = "uid") Long id) {
		adminService.deleteuser(id);
		return "Deleted Successfully";
	}

	@PutMapping("/UpdateUser/{userid}")
	private User update(@PathVariable(value = "userid") Long id, @RequestBody User user) {
		return adminService.Update(id, user);

	}
	// here Some Operation performed to Getting the data

		// Displays total bills generated today
		@GetMapping("/Display all bills today")
		public List<MyOrderHistory> Showallbillstoday() {
			LocalDate ld = LocalDate.now();
			return adminService.Showallbillstoday(ld);
		}

		// Displays allbills for that user
		@GetMapping("/User bill/{username}")
		public List<MyOrderHistory> UserBill(@PathVariable(value = "username") String uname) {
			return adminService.UserBill(uname);
		}

		// Displays total bills generated in this month
		@GetMapping("/Display all bills monthly")
		public List<MyOrderHistory> ShowallbillsMonthly() {
			return adminService.ShowallbillsMonthly();
		}

		// Displays Total Sale Amount for this month
		@GetMapping("/Monthly bill")
		public String totalMonthlybill() {
			return adminService.totalMonthlybill();
		}


		/*
		 * // Below Admin performed CRUD Operations on MenuItems
		 * 
		 * // Create New Item in Menu
		 * 
		 * @PostMapping("/Additem") public String registerItem(@RequestBody Item
		 * newitem) { adminService.saveitem(newitem); return
		 * "Item Inserted Successfully"; }
		 * 
		 * // Displays All Items in Menu
		 * 
		 * @GetMapping("/Displayitems") public List<Item> ShowallItems() { return
		 * adminService.ShowallItems(); }
		 * 
		 * // Deleting item by id
		 * 
		 * @DeleteMapping("/Deleteitem/{itemid}") private String
		 * deleteItem(@PathVariable(value = "itemid") Long id) {
		 * adminService.deleteitem(id); return "Deleted Successfully"; }
		 * 
		 * // Update item by id
		 * 
		 * @PutMapping("/Updateitem/{itemid}") private Item
		 * updateItem(@PathVariable(value = "itemid") Long id, @RequestBody Item menu) {
		 * return adminService.Update(id, menu); }
		 */

}
