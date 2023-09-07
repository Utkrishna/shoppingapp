package com.shopping.service;

import java.util.List;

import com.shopping.model.Orders;

public interface AdminDaoService {

	public boolean adminLoginValidation(String username,String password);
	public List<Orders> getOrders();
	public void deleteOrders(int orderid);
}
