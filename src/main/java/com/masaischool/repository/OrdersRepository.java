package com.masaischool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masaischool.models.Orders;

public interface OrdersRepository  extends JpaRepository<Orders,Integer>{

	@Query("select o from Orders o where o.user.id = :userId")
	List<Orders> fetchOrderHistoryOfAUser(Integer userId);

	
}
