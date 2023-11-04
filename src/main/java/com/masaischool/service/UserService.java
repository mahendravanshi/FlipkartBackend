package com.masaischool.service;

import java.util.Optional;

import com.masaischool.models.Orders;
import com.masaischool.models.Product;
import com.masaischool.models.User;
import com.masaischool.repository.OrdersRepository;

import jakarta.validation.Valid;

public interface UserService {
      
	User findByEmail(String emailString);
	
	public User addUser(User user);

	Orders placeOrder(Orders order, Integer userId);

	Orders addProducToOrder( Product product, Integer orderId);

	Orders updateOrder( Orders order, Integer orderId);
	
	
}
