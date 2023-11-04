package com.masaischool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masaischool.models.Orders;
import com.masaischool.repository.OrdersRepository;

import lombok.experimental.PackagePrivate;


@Service
public class OrderServiceImpl implements OrderService {

	
	private OrdersRepository ordersRepository;
	
	@Override
	public List<Orders> fetchOrderHistoryOfAUser(Integer userId) {
		
		
		return ordersRepository.fetchOrderHistoryOfAUser(userId);
	
	}
	
	

}
