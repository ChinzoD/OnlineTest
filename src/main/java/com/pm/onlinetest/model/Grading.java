package com.pm.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Grading {

	
 	@Id
    @GeneratedValue
    private Integer id;
 	
 	private double scaleFrom;
 	private double toFrom;
 	private String value;
 	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getFrom() {
		return scaleFrom;
	}
	public void setFrom(double from) {
		this.scaleFrom = from;
	}
	public double getTo() {
		return toFrom;
	}
	public void setTo(double to) {
		this.toFrom = to;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
 	
 	
 	
 	
}
