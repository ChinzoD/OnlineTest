package com.pm.onlinetest.domain;
import javax.persistence.Entity;

@Entity
public class Student extends User {

	private String entry;
	private Integer studentId;
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	
	
	
}
