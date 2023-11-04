package com.masaischool.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masaischool.models.User;
import com.masaischool.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class UsersDetailsServices  implements UserDetailsService{

	  @Autowired
	  private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("Loading uswername inside UsersDetailsServices class ");
		
		User user = userRepository.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("No user found with email "+email);
		}
		
		return user;
	}
	  
	  
}
