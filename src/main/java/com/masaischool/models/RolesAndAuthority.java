package com.masaischool.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RolesAndAuthority {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy="rolesandAuthoritiesSet")
	@ToString.Exclude
	private Set<User> userSet;
    
	public RolesAndAuthority(String name, Set<User> userSet) {
		super();
		this.name = name;
		this.userSet = userSet;
	}
	
	
	
	
	
}
