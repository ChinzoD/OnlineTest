package com.pm.onlinetest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subcategory {

 	@Id
    @GeneratedValue
    private Integer id;
 	
 	private String name;
 	
 	@ManyToOne
 	@JoinColumn(name = "category_id") 	  
 	private Category category;
 	
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)    
 	private Set<Question> questions;
 	
 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

 	
 	
}
