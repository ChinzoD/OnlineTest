package com.pm.onlinetest.domain;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pm.onlinetest.domain.Authority;


@Entity
@Table(name = "User", catalog = "onlinetest")
public class User implements java.io.Serializable {

	 	
	    private Integer userId;
	 
	    private String email;
	    private String username;
	    private String fname;
	    private String lname;
	    private String password;
	    private List<Authority> authorities;
	    
	    public User() {
		}

		public User(String username, String password, String verifyPassword, String firstName, String lastName,
				Integer gender, String email, boolean enabled, List<Authority> authorities) {
			this.username = username;
			this.password = password;
			this.email = email;
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

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
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

		@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
		public List<Authority> getAuthorities() {
			return this.authorities;
		}

		public void setAuthorities(List<Authority> authorities) {
			this.authorities = authorities;
		}
    
	    
}
