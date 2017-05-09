package com.pm.onlinetest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Choice;
import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Subcategory;
import com.pm.onlinetest.domain.Test;
import com.pm.onlinetest.service.AssignmentService;
import com.pm.onlinetest.service.CategoryService;
import com.pm.onlinetest.service.QuestionService;
import com.pm.onlinetest.service.SubCategoryService;
import com.pm.onlinetest.service.TestService;

import helpers.CategorySelectDto;
import helpers.CurrentQuestion;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TestService testService;
	
	@Autowired
	AssignmentService assignmentService;
	
	@Autowired
	SubCategoryService subCategoryService;

	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String showAccessPage(){
		return "access";
	}
	
	@RequestMapping(value="/access", method=RequestMethod.POST)
	public String verifyAccess(@RequestParam("access_code") String accesscode, RedirectAttributes attr){
		
		System.out.println(accesscode);
		
		Assignment assgnmentObj;
		
		//Check if Student has been assigned a test using the supplied Access Code
		if ((assgnmentObj = assignmentService.getAssignment(accesscode)) != null){
			//Add Assignment Object to Request attributes
			attr.addFlashAttribute("assignment", assgnmentObj);
			
			//Check if Student has previously finished test
			if (assgnmentObj.isFinished()){
				attr.addFlashAttribute("errormessage", "This Test has been completed.");
				return "redirect:/test";
			}
			else { //If Student has not previously finished,
				
                //Check if maximum number of attempts has not been exceeded
				if (assgnmentObj.getCount() < 3){
					
                    //Update Count attribute of Assignment object in database
				    assgnmentObj.setCount(assgnmentObj.getCount() + 1);
				    assignmentService.updateAccessCount(assgnmentObj);
                    
					if (assgnmentObj.isStarted()){//Check if Student has started Test previously
						
						//Check if time is still remaining
						LocalDateTime currentDate = LocalDateTime.now();
						if (currentDate.compareTo(assgnmentObj.getEnd_date()) == -1){
							
							//Authenticate Student and redirect to test page
							GrantedAuthority aut = new SimpleGrantedAuthority("ROLE_STUDENT");
							List<GrantedAuthority> roles = new ArrayList<>();
							roles.add(aut);
							Authentication authenticationToken = new UsernamePasswordAuthenticationToken(assgnmentObj.getStudentId(), accesscode, roles);
							SecurityContextHolder.getContext().setAuthentication(authenticationToken);
							
							return "redirect:/test/showtest";
						}else{
							attr.addFlashAttribute("errormessage", "No more time remaining for this test.");
							return "redirect:/test";
						}
					}else
					//If Student has not previously started, show page to select Categories
					return "redirect:/test/categories";
					
				}else{
				    attr.addFlashAttribute("errormessage", "This test has expired.");
					return "redirect:/test";
				}
			}				
			
		}
		
		//throw error/access denied page
		attr.addFlashAttribute("errormessage", "Invalid Access Code");
		return "redirect:/test";
	}
	
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String test403(Model model) {

		model.addAttribute("errormessage", "You are not authorized to perform this operation.");
		return "test/403";
	}
	
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public String showErrorPage(Model model){
		
		return "test/error";
	}
	
	@RequestMapping(value = "/showcategories", method = RequestMethod.GET)
	public String selectCategoriesView(Model model, HttpServletRequest request, RedirectAttributes attr) {
		
		Assignment obj = (Assignment) request.getAttribute("assignment");
		
		if (obj == null){
			attr.addFlashAttribute("errormessage", "Invalid Operation");
			return "redirect:/test/error";
		}
		
		CategorySelectDto dto = new CategorySelectDto();

		dto.setCategories(categoryService.findAllEnabled());
		model.addAttribute("categoryDto", dto);
		return "test/categoryselect";
	}
	
	@RequestMapping(value = "/setcategories", method = RequestMethod.POST)
	public String setCategories(@ModelAttribute("categoryDto") CategorySelectDto dto, BindingResult resultDto,
			HttpServletRequest request) {

		Integer assignmentId = Integer.parseInt(request.getSession().getAttribute("assignmentId").toString());
		Assignment assignment = assignmentService.findById(assignmentId);

		List<Test> existingTest = testService.findByAssignment(assignment);
		System.out.println("ExistingTest: " + existingTest.size());
		if (existingTest.size() == 0) {
			List<Integer> subcategories = dto.getSelectedSubCategories();

			Subcategory subcategory = null;
			Integer totalQuestions = 5;
			Random rand = new Random();
			for (Integer subcat_id : subcategories) {
				subcategory = subCategoryService.findOne(subcat_id);

				List<Question> subcategoryQuestions = questionService.findBySubcategory(subcategory);
				for (int i = 0; i < totalQuestions / subcategories.size(); i++) {

					int index = 0;
					if (subcategoryQuestions.size() > 0) {
						index = rand.nextInt(subcategoryQuestions.size());
					}

					Test test = new Test();
					test.setQuestion(subcategoryQuestions.remove(index));
					test.setAssignment(assignment);
					testService.save(test);
				}
			}
		}

		return "redirect:/test/test";

	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model, HttpServletRequest request) {
		Integer assignmentId = Integer.parseInt(request.getSession().getAttribute("assignmentId").toString());
		Assignment assignment = assignmentService.findById(assignmentId);
		List<Test> tests = new ArrayList<Test>();

		tests = testService.findByAssignment(assignment);
		request.getSession().setAttribute("tests", tests);
		model.addAttribute("test", tests.get(0));
		model.addAttribute("indexCount", tests.get(0).getId());

		return "test";
	}

	@RequestMapping(value = "/setAnswer", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject setAnswer(HttpServletRequest request, @RequestBody CurrentQuestion jsonString) {

		CurrentQuestion currentQuestion = jsonString;
		List<Test> tests = (List<Test>) request.getSession().getAttribute("tests");
		Test test = tests.get(currentQuestion.getQuestionNum());
		test.setAnswer(currentQuestion.getAnswer());
		testService.save(test);
		Test nextTest = testService.findOne(tests.get(currentQuestion.getNewQuestionNum()).getId());

		JSONObject obj = new JSONObject();
		obj.put("description", nextTest.getQuestion().getDescription());
		int i = 0;
		for(Choice ch: nextTest.getQuestion().getChoices()){
			obj.put("q"+i, ch.getDescription());
			i++;
		}
		obj.put("answer", nextTest.getAnswer());
		return obj;
	}

}