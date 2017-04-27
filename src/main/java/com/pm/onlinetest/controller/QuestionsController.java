package com.pm.onlinetest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Subcategory;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.service.CategoryService;
import com.pm.onlinetest.service.QuestionService;
import com.pm.onlinetest.service.SubCategoryService;

@Controller
@RequestMapping("/questions/")
public class QuestionsController {

	@Autowired
	QuestionService questionService;
	@Autowired
	CategoryService categoryService;
	/*@Autowired
	private SubCategoryService subCategoryService;*/
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addQuestion(Model model) {
		List<Category> listCategory = new ArrayList<>();
		listCategory.addAll(categoryService.findAll());
		Question q = new Question();
		model.addAttribute("question", q);
		model.addAttribute("categories",listCategory);
			return "questions/addquestion";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("question") Question question, BindingResult result, ModelMap model) {
	
		if (result.hasErrors()) {
			return "questions/addquestion";
		}
		
		
		
		questionService.save(question);
		return "questions/viewquestion";

	}
	
	@RequestMapping(value = "/testme", method = RequestMethod.GET)
	public String addQuestion1(Model m) {
		Question q = new Question();
		q.setDescription("birhanu");
		m.addAttribute("question", q);
		return "question/testme";
	}
	

	


}
