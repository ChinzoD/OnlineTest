package com.pm.onlinetest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pm.onlinetest.domain.Subcategory;
import com.pm.onlinetest.repository.SubCategoryRepository;
import com.pm.onlinetest.service.SubCategoryService;


@Service
public class SubCategoryServiceImp implements SubCategoryService {
	@Autowired
	SubCategoryRepository subCategoryRepository;

	@Override
	public List<Subcategory> findSubCategoryById(Integer catId) {
		return subCategoryRepository.findSubCategoryById(catId);
	}

	@Override
	public List<Subcategory> findAllEnabled() {
		// TODO Auto-generated method stub
		return subCategoryRepository.findAllEnabled();
	}

	@Override
	public void save(Subcategory subcategory) {
		// TODO Auto-generated method stub
		subCategoryRepository.save(subcategory);
	}

	@Override
	public void softDelete(Integer categoryId) {
		// TODO Auto-generated method stub
		subCategoryRepository.softDelete(categoryId);
	}

	@Override
	public List<Subcategory> findSubCategoryByName(String name) {
		// TODO Auto-generated method stub
		return subCategoryRepository.findSubCategoryByName(name);
	}

}
