package com.pm.onlinetest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Student;
import com.pm.onlinetest.domain.Test;
import com.pm.onlinetest.domain.User;
import com.pm.onlinetest.service.AssignmentService;
import com.pm.onlinetest.service.TestService;

import helpers.ReportBean;

/**
 * Controller class for Test report
 * @author wei.zhou
 *
 */
@Controller
@RequestMapping("/coach/reports/")
public class TestReportController {
	@Autowired
	TestService testService;
	@Autowired
	AssignmentService assignmentService;
	
	
	@RequestMapping(value = "single", method = RequestMethod.GET)
	public @ResponseBody void getOneReport(@RequestParam("assignmentId") Integer assignmentId) {
		ReportBean bean = new ReportBean();
		
		//Assignment assign = testService.getAssignment(accesscode);
	//	Test test = testService.getTestById(testId);
		
	//	List<Question> questions = testService.getAllQuestions(testId);
		// calculate grade, pass field...
		// bean.setGrade(100); // discuss in later 
		// bean.setPass(true);
		/*if (questions != null && !questions.isEmpty()) {
			bean.setSubCategory(questions.get(0).getSubcategory().getName());
		}*/
		
		Assignment assignment = assignmentService.findById(assignmentId);
		//Test test = testService.get
		Student student = (Student)assignment.getStudentId();
		
		bean.setDetail("See more details");
		bean.setName(student.getFirstName(), student.getLastName());
		bean.setStudentId(student.getStudentId());
		bean.setAssignmentId(Integer.toString(assignmentId));
		bean.setStartDate(assignment.getStart_date());
		bean.setCoach((User)assignment.getCoachId());
		
	//	return bean;
//		
		//assignmentService.getStudentById(student.geet());
		
	}
	
	@RequestMapping(value = "assignmentList", method = RequestMethod.GET)
	public String getAllReports(Model model) {
//		List<ReportBean> reportBeans = new ArrayList<>();
//		ReportBean bean = new ReportBean();
//		
//		Assignment assign = testService.getAssignment(accesscode);
//		Set<Test> tests = assign.getTests();
		// loop this test Set, generate one report code by one Test obj. 
		// the same with above method
		
		System.out.println("Samuel Test 8888888 getAllReports ");
		List<Assignment> assignmentList = assignmentService.findAll();
		model.addAttribute("assignmentList", assignmentList);
		return "assignmentList";
	}
	
	
}
