package com.pm.onlinetest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.repository.CategoryRepository;
import com.pm.onlinetest.service.CategoryService;

@Service

public class CategoryServiceImp implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override

	public List<Category> findAll() {

		return (List<Category>) categoryRepository.findAll();

	}

}
