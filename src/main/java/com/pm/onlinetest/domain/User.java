package com.pm.onlinetest.domain;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.pm.onlinetest.domain.Authority;
import  javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User{

	 	
	    private Integer userId;
	 
	    private String email;
	    private String username;
	    private String firstName;
	    private String lastName;
	    private String password;
	    private boolean enabled; 
	    
	    
	    private List<Authority> authorities;
	  	    
	    public User() {
		}
	    
	    public User(String username, String password, boolean enabled) {
			this.username = username;
			this.password = password;
			this.enabled = enabled;
		}

		public User(String username, String password, String verifyPassword, String firstName, String lastName,
				Integer gender, String email, boolean enabled, List<Authority> authorities) {
			this.username = username;
			this.password = password;
			this.email = email;
			this.authorities = authorities;
			
			
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			//this.gender = gender;
			this.email = email;
			this.enabled = enabled;
			this.authorities = authorities;
		}
		
		@Id
		@GeneratedValue(strategy = IDENTITY)

		@Column(name = "userId", unique = true, nullable = false)
		public Integer getUserId() {
			return this.userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


    
		@Column(name = "enabled", nullable = false, columnDefinition = "BIT", length = 1)
		public boolean isEnabled() {
			return this.enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
		public List<Authority> getAuthorities() {
			return this.authorities;
		}

		public void setAuthorities(List<Authority> authorities) {
			this.authorities = authorities;
		}
   


}
