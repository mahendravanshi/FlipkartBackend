package com.masaischool.service;

import java.util.List;

import com.masaischool.models.Orders;

public interface OrderService {

	List<Orders> fetchOrderHistoryOfAUser(Integer userId);

}
