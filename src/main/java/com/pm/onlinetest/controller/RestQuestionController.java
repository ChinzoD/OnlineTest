package com.pm.onlinetest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pm.onlinetest.domain.Subcategory;

import com.pm.onlinetest.service.SubCategoryService;

@RestController
@RequestMapping(value = "/subcategories")
public class RestQuestionController {
	@Autowired
	private SubCategoryService subCategoryService;
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Subcategory> subCategories(@RequestParam("catId") Integer catId, Model model) {
		List<Subcategory> listSubCategory = new ArrayList<>();
		listSubCategory.addAll(subCategoryService.findSubCategoryById(catId));
		return listSubCategory;
	}
}
