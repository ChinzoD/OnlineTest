package com.pm.onlinetest.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
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

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.User;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Choice;
import com.pm.onlinetest.service.CategoryService;
import com.pm.onlinetest.service.QuestionService;


@Controller
@RequestMapping("/questions/")
public class QuestionsController {

	@Autowired
	QuestionService questionService;
	@Autowired
	CategoryService categoryService;


	@RequestMapping(value = "/addquestion", method = RequestMethod.GET)
	public String addQuestion(Model model) {
		List<Category> listCategory = new ArrayList<>();
		listCategory.addAll(categoryService.findAll());
		Question q = new Question();
		model.addAttribute("question", q);
		model.addAttribute("categories", listCategory);
		return "questions/addquestion";
	}

	@RequestMapping(value = "addquestion", method = RequestMethod.POST)
	public String addQuestion(@Valid @ModelAttribute("question")Question question, BindingResult result, RedirectAttributes redirectAttr,Model model) {

		if (result.hasErrors()) {
			List<Category> listCategory = new ArrayList<>();
			listCategory.addAll(categoryService.findAll());
						model.addAttribute("categories", listCategory);
			return "questions/addquestion";
		}

		Set<String> choices = question.getListOfchoice();
		Set<Choice> c = new HashSet<>();
		Choice choice = null;

		for (String choiceDesc : choices) {
			choice = new Choice();
			choice.setQuestion(question);
			choice.setDescription(choiceDesc);
			c.add(choice);

		}

		question.setChoices(c);
		questionService.save(question);
		redirectAttr.addFlashAttribute("success", "The question Successfully added !");
		redirectAttr.addFlashAttribute("question", question);
		return "redirect:/questions/addquestion";

	}

	@RequestMapping(value = "/viewquestions", method = RequestMethod.GET)
	public String addQuestion1(Model m) {
	List<Question> questions= questionService.findAll();	
	
		m.addAttribute("questions", questions);
		return "questions/viewquestions";
	}
	@RequestMapping(value = { "/deleteQuestion" }, method = RequestMethod.POST)
	public void DeleteQuestion(HttpServletRequest request) {
		String id = request.getParameter("id").toString();
		Question question = questionService.findQuestionById(Integer.parseInt(id));
		questionService.delete(question);
	}

}
