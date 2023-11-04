package com.masaischool.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AppConfig {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
		http.sessionManagement(
				sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.cors(cors -> {
					cors.configurationSource(new CorsConfigurationSource() {
						@Override
						public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
							CorsConfiguration configuration = new CorsConfiguration();
							configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
							configuration.setAllowedMethods(Collections.singletonList("*"));
							configuration.setAllowCredentials(true);
							configuration.setAllowedHeaders(Collections.singletonList("*"));
							configuration.setExposedHeaders(Arrays.asList("Authorization"));
							return configuration;
						}
					});
				}).authorizeHttpRequests(auth -> {
					auth.requestMatchers("/swagger-ui*/**", "/v3/api-docs/**").permitAll()
							.requestMatchers(HttpMethod.POST, "/users").permitAll() // User
							.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
							.requestMatchers(HttpMethod.POST, "/orders/**").hasRole("USER")
							.requestMatchers(HttpMethod.PUT, "/orders/**").hasRole("USER")
							
							.requestMatchers(HttpMethod.GET, "/users/**/orders").hasRole("USER")
							.requestMatchers(HttpMethod.GET, "/users/**/recommended-products").hasRole("USER")

							.requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN") // Admin
							.requestMatchers(HttpMethod.POST, "/categories").hasRole("ADMIN")
							.requestMatchers(HttpMethod.POST, "/users/admin").hasRole("ADMIN")
							.requestMatchers(HttpMethod.DELETE, "/orders/**/admin").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET, "/users/admin").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET, "/products/admin").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET, "/categories/admin").hasRole("ADMIN")

							.anyRequest().authenticated();
				}).csrf(csrf -> csrf.disable()).formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	/**
	 * POST /users - Register a new user [ Points: 0.25 ]
	 * 
	 * POST /auth/login - Authenticate a user and return JWT [ Points: 0.25 ]
	 * 
	 * POST /orders/{userId} - Allow a user to create an order [ Points: 0.50 ]
	 * 
	 * PUT /orders/{orderId}/products - Allow a user to add a product to an order [
	 * Points: 0.25 ]
	 * 
	 * PUT /orders/{orderId} - Allow a user to update the order details (delivery
	 * date, quantity of products) [ Points: 0.25 ]
	 * 
	 * GET /users/{userId}/orders - Fetch a user's order history [ Points: 0.25 ]
	 * 
	 * GET /users/{userId}/recommended-products - Recommend products to a user based
	 * on their order history.
	 * 
	 * @return
	 * 
	 * POST /products - Add new products 
POST /categories - Add new categories 
POST /users/admin - Add new users (admin) 
DELETE /orders/{orderId}/admin - Delete an order (admin) 
GET /users/admin - Fetch all users (admin) 
GET /products/admin - Fetch all products (admin) 
GET /categories/admin - Fetch all categories (admin) 
	 * 
	  
	 */

	@Bean

	public PasswordEncoder getPassWordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
