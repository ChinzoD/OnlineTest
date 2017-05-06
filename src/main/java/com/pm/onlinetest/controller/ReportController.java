package com.pm.onlinetest.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Subcategory;
import com.pm.onlinetest.domain.Test;
import com.pm.onlinetest.service.AssignmentService;
import com.pm.onlinetest.service.ChoiceService;
import com.pm.onlinetest.service.SearchService;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	SearchService searchService;
	
	@Autowired
	AssignmentService assignmentService;
	
	@Autowired
	ChoiceService choiceService;
		
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String testResult(Model model) {
		
		
		HashMap<Subcategory, String> report = new HashMap<>();
		
		Set<Subcategory> subcats = new HashSet<>(); 
		Assignment assignment = assignmentService.findById(1) ;
		Set<Test> tests = assignment.getTests();

		for(Test test : tests){
			subcats.add(test.getQuestion().getSubcategory());
		}
		
		int numberofQuestions = tests.size();
		int overAllTotal = 0;
		double overAllAverage = 0;
		for(Subcategory subcat : subcats){
			
			
			int scorePerCategory = 0;
			int totalQuestionsPerCategory = 0;
			for(Test testQuestion : tests){
				if(testQuestion.getQuestion().getSubcategory().equals(subcat)){
					totalQuestionsPerCategory++;
					System.out.println(testQuestion.getAnswer());
					System.out.println(choiceService.getAnswer(testQuestion.getQuestion()).getId());
					
					if(Integer.parseInt(testQuestion.getAnswer()) == choiceService.getAnswer(testQuestion.getQuestion()).getId()){
						overAllTotal++;
						scorePerCategory++;
					}
				}
			}
			report.put(subcat, scorePerCategory+" out of "+totalQuestionsPerCategory);
			overAllAverage = 0;
			totalQuestionsPerCategory=0;
		}
		model.addAttribute("reports", report);
		model.addAttribute("total", overAllTotal);
		model.addAttribute("questions", numberofQuestions);
		return "result";
		
	}
	
	@RequestMapping(value = "/resultDetail", method = RequestMethod.GET)
	public String testResultDetail(Model model) {
		
		HashMap<Test, Boolean> reportDetail = new HashMap<>();
		Assignment assignment = assignmentService.findById(1) ;
		Set<Test> tests = assignment.getTests();

			for(Test testQuestion : tests){
				boolean answer = false ;
					if(Integer.parseInt(testQuestion.getAnswer()) == choiceService.getAnswer(testQuestion.getQuestion()).getId()){
						answer=true;
						reportDetail.put(testQuestion, answer);
					}
					reportDetail.put(testQuestion, answer);
				}
			
			
		model.addAttribute("answers", reportDetail);
		
		return "resultDetail";
		
	}
	
	
	
	@RequestMapping(value = "/accessCode", method = RequestMethod.GET)
	public String getUsers(Locale locale, Model model) {
		List<Question> questions = searchService.findAll();
		model.addAttribute("questions", questions);
		return "questions";
		
		
		
		
		
	}
	
	
	
	
}