package com.pm.onlinetest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Grading;
import com.pm.onlinetest.repository.CategoryRepository;
import com.pm.onlinetest.repository.GradingRepository;
import com.pm.onlinetest.service.CategoryService;
import com.pm.onlinetest.service.GradingService;

@Service

public class GradingServiceImpl implements GradingService {
	@Autowired
	GradingRepository  gradingRepository;

	@Override
	public List<Grading> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Grading> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grading> findAllEnabled() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findOne(Integer grading) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void softDelete(Integer grade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Grading crading) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Grading> findCategoryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findGrade(double score) {
		// gradingRepository.findGrade(score);
		return "A";
	}

	

	

}
