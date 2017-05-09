package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Subcategory;

public interface SubCategoryService {

	public List<Subcategory> findByCategoryId(Integer catId);
	public List<Subcategory> findAllEnabled();
	public Subcategory findOne(Integer subCategoryId);
	public void softDelete(Integer subCategoryId);
	public void save(Subcategory subcategory);
	public List<Subcategory> findSubCategoryByName(String name);
}
