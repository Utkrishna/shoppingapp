package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Products;
import com.shopping.service.ProductsDaoService;

@RestController
public class ProductsController {

	@Autowired
	private ProductsDaoService prodService;
	
	@GetMapping("/getProducts")
	public List<Products> getProducts(){
		return prodService.getProducts();
		
	}
	@PostMapping("/addProducts")
	public void addProducts(@RequestBody Products product) {
		prodService.addProducts(product);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteProducts/{ProId}")
	public void deleteProducts(@PathVariable int ProId) {
		prodService.deleteProducts(ProId);
	}
	
	@PutMapping("/updateProducts")
	public void updateProducts(@RequestBody Products product) {
		prodService.updateProducts(product);
	}
}
