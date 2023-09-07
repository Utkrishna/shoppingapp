package com.shopping.service;

import java.util.List;

import com.shopping.model.Products;

public interface ProductsDaoService {

	public List<Products> getProducts();//Read Operation
	public void addProducts(Products product);//Create Operation
	public void deleteProducts(int ProId);//Delete Operation
	public void updateProducts(Products product);//Update operation
	
}
