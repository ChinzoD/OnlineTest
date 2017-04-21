package com.pm.onlinetest.domain;
// Generated Oct 26, 2016 2:24:30 PM by Hibernate Tools 5.1.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;



import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Authority{

	private Integer id;
	
	
	private User user;
	
	private Role role;


	public Authority() {
	}



	public Authority(Integer id, User user, Role role) {
		
		this.id = id;
		this.user = user;
		this.role = role;
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", nullable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
