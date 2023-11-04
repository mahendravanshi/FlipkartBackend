package com.masaischool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.models.Orders;
import com.masaischool.models.Product;
import com.masaischool.models.User;
import com.masaischool.repository.OrdersRepository;
import com.masaischool.service.OrderService;
import com.masaischool.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;


@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	
	private OrderService orderService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 //POST /users - Register a new user
	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		
		String passwordString = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(passwordString);
		
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
		
	}
	
	//POST /auth/login - Authenticate a user
	@PostMapping("/auth/login")
	public ResponseEntity<User> authLogin(){
		
		return null;
	}
	
	//POST /orders/{userId} - Allow a user to create an order 
	
	@PostMapping("/orders/userId")
	public ResponseEntity<Orders> placeOrder(@Valid @RequestBody Orders order,@PathVariable Integer userId){
		
		return new ResponseEntity<>(userService.placeOrder(order,userId),HttpStatus.CREATED);
		
	}
	
	
	//PUT /orders/{orderId}/products - Allow a user to add a product to an order
	
	@PutMapping("/orders/{orderId}/products")
     public ResponseEntity<Orders> addProductToOrder(@Valid @RequestBody Product product,@PathVariable Integer orderId){
		
		return new ResponseEntity<>(userService.addProducToOrder(product,orderId),HttpStatus.CREATED);
		
	}
	
	//PUT /orders/{orderId} - Allow a user to update the order details (delivery date, quantity of products)
	@PutMapping("/orders/{orderId}")
    public ResponseEntity<Orders> updateOrderetails(@Valid @RequestBody Orders order,@PathVariable Integer orderId){
		
		return new ResponseEntity<>(userService.updateOrder(order,orderId),HttpStatus.CREATED);
		
	}
	
	
	//ET /users/{userId}/orders - Fetch a user's order history 
	
	@GetMapping("/users/{userId}/orders")
	public ResponseEntity<List<Orders>> getUseraOrderHistory(@PathVariable Integer userId){
		
		return new ResponseEntity<>(orderService.fetchOrderHistoryOfAUser(userId),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
