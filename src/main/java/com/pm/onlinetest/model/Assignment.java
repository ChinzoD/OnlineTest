package com.pm.onlinetest.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Assignment {

 	@Id
    @GeneratedValue
    private Integer id;
 	private LocalDate start_date;
 	private LocalDate end_date;
 	private Integer count;
 	private boolean finished;
 	
 	@OneToOne(cascade = CascadeType.ALL)	
 	private User studentId;
 	
 	@OneToOne(cascade = CascadeType.ALL)	
 	private User coachId;
 	
 	@OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)  	
 	private Set<Test> tests;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public User getStudentId() {
		return studentId;
	}

	public void setStudentId(User studentId) {
		this.studentId = studentId;
	}

	public User getCoachId() {
		return coachId;
	}

	public void setCoachId(User coachId) {
		this.coachId = coachId;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

 	

 	
 	
 	
 	
 	
}
