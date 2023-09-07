package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Orders;
import com.shopping.service.OrdersDaoService;

@RestController
public class OrdersController {

	@Autowired
	private OrdersDaoService orders;
	
	@GetMapping("/getOrders")
	public List<Orders> getOrders(){
		return orders.getOrders();
	}
	
	@PostMapping("/addOrders")
	public void addOrders(@RequestBody Orders order) {
		orders.addOrders(order);
	}
}
