package com.pm.onlinetest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.service.QuestionService;
import com.pm.onlinetest.service.impl.QuestionServiceImp;

import helpers.CategorySelectDto;

@Controller
@RequestMapping("/questions")
public class QuestionsController {
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addQuestion() {

	}

}
