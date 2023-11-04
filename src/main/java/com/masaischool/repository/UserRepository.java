package com.masaischool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
        
	
	    User findByEmail(String emailString);
}
