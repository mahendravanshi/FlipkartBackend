package com.masaischool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.exceptions.OrderNotFoundException;
import com.masaischool.exceptions.UserNotFoundException;
import com.masaischool.models.Orders;
import com.masaischool.models.Product;
import com.masaischool.models.User;
import com.masaischool.repository.OrdersRepository;
import com.masaischool.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public User findByEmail(String emailString) {
		
		User user = userRepository.findByEmail(emailString);
		if(user==null) {
			throw new UserNotFoundException("No user found with email "+emailString);
		}
		
		return user;
	}

      
	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}


	@Override
	public Orders placeOrder(Orders order, Integer userId) {
		
		 User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found with user id "+userId));
		 
		 user.getOrders().add(order);
		 order.setUser(user);
		 
		 userRepository.save(user);
		 
		 return order;
	}


	@Override
	public Orders addProducToOrder(Product product, Integer orderId) {
		
		Orders orders = ordersRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("No order found with order id "+orderId));
		
		orders.getProducts().add(product);
		
		ordersRepository.save(orders);
		
		return orders;
	}

	
	

	@Override
	public Orders updateOrder(Orders order, Integer orderId) {
		Orders orders = ordersRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Noorder found with order id "+orderId));
	
		order.setId(orderId);
		
        ordersRepository.save(order);
		
		return order;
	
	}
	
	
	
	
	
	
}
