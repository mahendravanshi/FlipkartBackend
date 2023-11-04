package com.masaischool.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class User implements UserDetails,CredentialsContainer {

	//User: The User entity should have a unique userId, name, email, password, and role.    Done

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="name required")
	private String name;
	
	@Column(name="email",unique=true,nullable=false)
	@Email
	private String email;
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_auth",
	joinColumns = @JoinColumn(referencedColumnName = "id",name="user_id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName = "id",name="role_id")
	)
	private  Set<RolesAndAuthority> rolesandAuthoritiesSet;
	
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Orders> orders;

	

	@Override
	public void eraseCredentials() {
		this.password = null;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<SimpleGrantedAuthority> set = new HashSet<>();
		
		for(RolesAndAuthority rolesAndAuthority : rolesandAuthoritiesSet) {
			
			set.add(new SimpleGrantedAuthority(rolesAndAuthority.getName()));
		}
		
		return set;
	}

	@Override
	public String getUsername() {
		
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
	
}



