package com.pm.onlinetest.domain;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Role {

	

 	@Id
    @GeneratedValue
    private Integer id;
 	
 	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")	
 	private Set<User> users = new HashSet<User>(0);

 	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


 	

 	
 	
 	
 	
}
