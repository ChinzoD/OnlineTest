package com.pm.onlinetest.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private Integer id;
	private String description;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.REMOVE)
	private Set<Choice> choices;

	@ManyToOne
	@JoinColumn(name = "subcategory_id")
	private Subcategory subcategory;

	@OneToMany(mappedBy = "question")
	private Set<Test> tests;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Choice> getChoices() {
		return choices;
	}

	public void setChoices(Set<Choice> choices) {
		this.choices = choices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

}
