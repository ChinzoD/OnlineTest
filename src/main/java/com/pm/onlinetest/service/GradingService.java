package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Grading;

public interface GradingService {

	public List<Grading> findAll();
	public Iterable<Grading> getAllCategories();
	// public void save(Question question);
	public List<Grading> findAllEnabled();
	public Category findOne(Integer grading);
	public void softDelete(Integer grade);
	public void save(Grading crading);
	public List<Grading> findCategoryByName(String name);
	public String findGrade(double score);
	
}
