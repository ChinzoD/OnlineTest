package com.pm.onlinetest.domain;
import javax.persistence.*;

@Entity
public class Student_Record {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Student student;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User coach;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public User getCoach() {
		return coach;
	}

	public void setCoach(User coach) {
		this.coach = coach;
	}
	
	
	
	
	
}
