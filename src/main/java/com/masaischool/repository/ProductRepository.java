package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
