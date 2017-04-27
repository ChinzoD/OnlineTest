package com.pm.onlinetest.service;

import java.util.List;


import com.pm.onlinetest.domain.Subcategory;

public interface SubCategoryService {
	
public List<Subcategory>	findSubCategoryById(Integer catId);
}
