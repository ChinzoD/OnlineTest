package com.pm.onlinetest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Grading {

	
 	@Id
    @GeneratedValue
    private Integer id;
 	
 	private double fromScale;
 	private double toScale;
 	private String value;
 	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getFromScale() {
		return fromScale;
	}
	public void setFromScale(double fromScale) {
		this.fromScale = fromScale;
	}
	public double getToScale() {
		return toScale;
	}
	public void setToScale(double toScale) {
		this.toScale = toScale;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
 	
 	
 	
 	
}
