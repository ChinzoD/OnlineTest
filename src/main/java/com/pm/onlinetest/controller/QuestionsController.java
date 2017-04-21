package com.pm.onlinetest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/questions/")
public class QuestionsController {
	@RequestMapping(value = "/add", method = RequestMethod.POST)

	public void addQuestion() {

	}

}
