package com.masaischool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.models.Product;
import com.masaischool.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {

	
	
	
	//POST /products - Add new products 
	
	@Autowired
	
	private ProductService productService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		
		return new ResponseEntity<>(productService.addProduct(product),HttpStatus.CREATED);
	}
	
	
	
}
