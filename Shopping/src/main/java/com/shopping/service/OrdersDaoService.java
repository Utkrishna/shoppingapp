package com.shopping.service;

import java.util.List;

import com.shopping.model.Orders;

public interface OrdersDaoService {

	public List<Orders> getOrders();
	public void addOrders(Orders order);
}
