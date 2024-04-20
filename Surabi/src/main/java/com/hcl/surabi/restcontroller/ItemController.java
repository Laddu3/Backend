package com.hcl.surabi.restcontroller;

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

import com.hcl.surabi.entity.Item;
import com.hcl.surabi.service.AdminService;

@RestController
@RequestMapping("/Admin") 
public class ItemController {
	@Autowired
	AdminService adminService;

	// Below Admin performed CRUD Operations on MenuItems

	// Create New Item in Menu
	@PostMapping("/Additem")
	public String registerItem(@RequestBody Item newitem) {
		adminService.saveitem(newitem);
		return "Item Inserted Successfully";
	}

	// Displays All Items in Menu
	@GetMapping("/Displayitems")
	public List<Item> ShowallItems() {
		return adminService.ShowallItems();
	}

	// Deleting item by id
	@DeleteMapping("/Deleteitem/{itemid}")
	private String deleteItem(@PathVariable(value = "itemid") Long id) {
		adminService.deleteitem(id);
		return "Deleted Successfully";
	}

	// Update item by id
	@PutMapping("/Updateitem/{itemid}")
	private Item updateItem(@PathVariable(value = "itemid") Long id, @RequestBody Item menu) {
		return adminService.Update(id, menu);
	}

}