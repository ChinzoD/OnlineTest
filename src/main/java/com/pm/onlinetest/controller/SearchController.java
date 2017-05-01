package com.pm.onlinetest.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.service.SearchService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchService searchService;
	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public void addQuestion() {

	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public String getUsers(Locale locale, Model model) {
		List<Question> questions = searchService.findAll();
		model.addAttribute("questions", questions);
		return "questions";
	}
	
}