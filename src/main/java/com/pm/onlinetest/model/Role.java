package com.pm.onlinetest.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Role {

	

 	@Id
    @GeneratedValue
    private Integer id;
 	
 	  @ManyToOne
 	    @JoinColumn(name = "user_id")
 	  private User user;
 	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
 	
 	

 	
 	
 	
 	
}
