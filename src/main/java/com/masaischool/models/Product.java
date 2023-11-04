package com.masaischool.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	
	public enum Status{
		IN_STOCK,OUT_OF_STOCK
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Product name required")
	private String nameString;
	
	@Min(value=1L,message="product price should be greater than 0")
	private Double priceDouble;
	
	@Min(value=0L,message="quantity cannot be less than 0")
	private  int quantity;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Orders orders;
	
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	
	
}


//Product: The Product entity should have a unique productId, name, price, category, quantity (representing available stock), 
//and a derived status indicating if it's in-stock or out-of-stock based on the quantity.
