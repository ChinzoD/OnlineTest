package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Category;

public interface CategoryService {
	public List<Category> findAll();
	public Iterable<Category> getAllCategories();
	// public void save(Question question);
	// void update(long id,Question book);
	// void delete(long id);
}
