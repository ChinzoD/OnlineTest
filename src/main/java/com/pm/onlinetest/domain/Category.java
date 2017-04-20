package com.pm.onlinetest.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

 	@Id
    @GeneratedValue
    private Integer id;
 	
 	private String name;
 	
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)	
 	private Set<Subcategory> subcategories;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

    
    
    
 

 	
 	
}
