package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Subcategory;

public interface SubCategoryService {

	public List<Subcategory> findSubCategoryById(Integer catId);
	public List<Subcategory> findAllEnabled();
	public void softDelete(Integer categoryId);
	public void save(Subcategory subcategory);
	public List<Subcategory> findSubCategoryByName(String name);
}
