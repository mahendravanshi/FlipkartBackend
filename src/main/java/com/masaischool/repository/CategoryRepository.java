package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
   
	  
}
