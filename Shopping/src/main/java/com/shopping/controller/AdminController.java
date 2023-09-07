package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Orders;
import com.shopping.service.AdminDaoService;

@RestController
public class AdminController {

	@Autowired
	public AdminDaoService adminService;
	
	@GetMapping("admin/{username}/{password}")
	public boolean adminLoginValidation(@PathVariable String username,@PathVariable String password) {
		return adminService.adminLoginValidation(username, password);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="adminorderview")
	public List<Orders> getOrders(){
		return adminService.getOrders();
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/adminorderdelete/{orderid}")
	public void deleteOrders(int orderid) {
		adminService.deleteOrders(orderid);
	}
}
