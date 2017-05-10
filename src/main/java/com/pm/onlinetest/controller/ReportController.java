package com.pm.onlinetest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Subcategory;
import com.pm.onlinetest.domain.Test;
import com.pm.onlinetest.service.AssignmentService;
import com.pm.onlinetest.service.ChoiceService;
import com.pm.onlinetest.service.GradeService;
import com.pm.onlinetest.service.SearchService;

@Controller
@RequestMapping("/coach")
public class ReportController {

	@Autowired
	SearchService searchService;
	
	@Autowired
	AssignmentService assignmentService;

	@Autowired
	GradeService gradeService;
	
	@Autowired
	ChoiceService choiceService;

	@RequestMapping(value = "/result/{id}", method = RequestMethod.GET)
	public String testResult(@PathVariable("id") int id, Model model) {

		HashMap<Subcategory, String> report = new HashMap<>();

		Set<Subcategory> subcats = new HashSet<>();
		Assignment assignment = assignmentService.findById(id);
		Set<Test> tests = assignment.getTests();

		for (Test test : tests) {
			subcats.add(test.getQuestion().getSubcategory());
		}

		int numberofQuestions = tests.size();
		int overAllTotal = 0;
		double overAllAverage = 0;
		for (Subcategory subcat : subcats) {

			int scorePerCategory = 0;
			int totalQuestionsPerCategory = 0;
			for (Test testQuestion : tests) {
				if (testQuestion.getQuestion().getSubcategory().equals(subcat)) {
					totalQuestionsPerCategory++;
					System.out.println(testQuestion.getAnswer());
					System.out.println(choiceService.getTrueAnswer(testQuestion.getQuestion()).getId());

					if (testQuestion.getAnswer() == choiceService.getTrueAnswer(testQuestion.getQuestion()).getId()) {
						overAllTotal++;
						scorePerCategory++;
					}
				}
			}
			//
			report.put(subcat,
					scorePerCategory + " / " + totalQuestionsPerCategory + "  |   "
							+ scorePerCategory * 100 / totalQuestionsPerCategory + "%  |  Grade : "
							+ gradeService.getGradeAsStringFromInteger(scorePerCategory * 100 / totalQuestionsPerCategory));
			overAllAverage = 0;
			totalQuestionsPerCategory = 0;
		}
		model.addAttribute("reports", report);
		model.addAttribute("total", overAllTotal);
		model.addAttribute("questions", numberofQuestions);
		model.addAttribute("studentAssignment", assignment);
		return "result";

	}

	@RequestMapping(value = "/resultDetail/{id}", method = RequestMethod.GET)
	public String testResultDetail(@PathVariable("id") int id, Model model) {

		HashMap<Test, Boolean> reportDetail = new HashMap<>();
		Assignment assignment = assignmentService.findById(id);
		Set<Test> tests = assignment.getTests();
		int score = 0;

		for (Test testQuestion : tests) {
			boolean answer = false;
			if (testQuestion.getAnswer() == choiceService.getTrueAnswer(testQuestion.getQuestion()).getId()) {
				answer = true;
				score++;
				reportDetail.put(testQuestion, answer);
			}
			reportDetail.put(testQuestion, answer);
		}

		model.addAttribute("answers", reportDetail);
		model.addAttribute("student", assignmentService.findById(1).getStudentId());
		model.addAttribute("score", score + "/" + tests.size());
		model.addAttribute("percent", score * 100 / tests.size());
		return "resultDetail";

	}

	@RequestMapping(value = "/assignments", method = RequestMethod.GET)
	public String assignmentDetail(Model model) {

		List<Assignment> assignments = assignmentService.findAll();
		model.addAttribute("assignments", assignments);
		return "assignments";

	}

	@RequestMapping(value = "/resultlist", method = RequestMethod.GET)
	public String resultList(Model model) {

		
		
		
		HashMap<Assignment, Integer> reports = new HashMap<>();
	List<Assignment> finisedAssignmentList = new ArrayList<>();
		List<Assignment> assignments = assignmentService.findAll();
		//filter only the finished tests
		for(Assignment assign : assignments){
			if(assign.isFinished()==true){
				finisedAssignmentList.add(assign);
			}
		}
		
		int score = 0;
		for (Assignment assignment : finisedAssignmentList) {
			for (Test testQuestion : assignment.getTests()) {
				if (testQuestion.getAnswer() == choiceService.getTrueAnswer(testQuestion.getQuestion()).getId()) {
					score++;

				}
				reports.put(assignment, score * 100 / assignment.getTests().size());

			}

			model.addAttribute("reports", reports);
			

		}
		return "resultlist";
	}
	
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String giveFeedback(Model model) {
		return "feedback";

	}
	
	
}