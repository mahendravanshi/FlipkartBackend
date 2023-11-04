package com.masaischool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.models.Product;
import com.masaischool.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository produtRepository;
	
	
	

	@Override
	public Product addProduct(Product product) {
		
		return produtRepository.save(product);

		
	}
	
	
	

}
