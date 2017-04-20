package com.pm.onlinetest.model;


import java.util.Set;

import javax.persistence.*;


@Entity
public class User {

	 	@Id
	    @GeneratedValue
	    private Integer id;
	 
	    private String email;
	    private String username;
	    private String fname;
	    private String lname;
	    private String password;
	 
	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private Set<Role> roles ;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}


	    
	    
	    
	    
	    
	    
	    
}
