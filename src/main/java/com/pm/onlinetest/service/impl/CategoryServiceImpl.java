package com.pm.onlinetest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.repository.CategoryRepository;
import com.pm.onlinetest.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
@Autowired
CategoryRepository catrepo;
	

	@Override
	public List<Category> getAllCategories() {
		List<Category>categories=(List<Category>)catrepo.findAll();
		return categories;
	}
}
