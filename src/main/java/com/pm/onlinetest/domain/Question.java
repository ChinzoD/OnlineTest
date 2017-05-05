package com.pm.onlinetest.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Question {

 	@Id
    @GeneratedValue
    private Integer id;
 @NotEmpty(message="Question can not empty")
    private String description;
    @Transient
	private String category;
	

	@ManyToOne
 	@JoinColumn(name = "subcategory_id") 	   
    private Subcategory subcategory;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)	   
	private List<Choice> choices;
    @Transient
	private Set<String> listOfchoice;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
	private Set<Test> tests;
   /* @Transient
	private Set<String> isAnswer;*/
    
    
	//private List<Choice> choicesAsList;

	
 // to bind with controller
	/*public List<Choice> getChoicesAsList() {
		return new ArrayList<Choice> (choices);
	}*/

	public Set<String> getListOfchoice() {
		return listOfchoice;
	}

	public void setListOfchoice(Set<String> listOfchoice) {
		this.listOfchoice = listOfchoice;
	}
	/*public Set<String> getAnswer() {
		return isAnswer;
	}

	public void setAnswer(Set<String> answer) {
		this.isAnswer = answer;
	}
*/
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

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
    

}
