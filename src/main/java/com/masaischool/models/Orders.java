package com.masaischool.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy="orders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Product> products; // unidirectional
	
	@Min(value=1L,message="total price should be greater than 0")
	private Double totalPriceDouble;
	
	@FutureOrPresent(message="Delivery date is not valid")
	private LocalDate deliveryDate;
	
	
	
}

//Orders: The Orders entity should have a unique orderId, userId, products (a list of productIds), total price, and delivery date.
