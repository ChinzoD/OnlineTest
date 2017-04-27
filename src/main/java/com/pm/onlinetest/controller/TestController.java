package com.pm.onlinetest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.service.QuestionService;
import com.pm.onlinetest.service.TestService;

import helpers.CategorySelectDto;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	TestService testService;
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String showAccessPage(){
		return "test/access";
	}
	
	@RequestMapping(value="/access", method=RequestMethod.POST)
	public String verifyAccess(@RequestParam("access_code") String accesscode, RedirectAttributes attr){
		
		System.out.println(accesscode);
		
		Assignment assgnmentObj;
		
		//Check if Student has been assigned a test using the supplied Access Code
		if ((assgnmentObj = testService.getAssignment(accesscode)) != null){
			//Add Assignment Object to Page attributes
			attr.addFlashAttribute("assignment", assgnmentObj);
			
			//Check if Student has previously finished test
			if (assgnmentObj.isFinished())
				return "redirect:/errorpage";
			else { //If Student has not previously finished,
				
				if (assgnmentObj.isStarted()){//Check if Student has even started Test previously
					//If Student has started previously, check if time is still remaining
					LocalDateTime currentDate = LocalDateTime.now();
					if (currentDate.compareTo(assgnmentObj.getEnd_date()) == -1){
						//If time is remaining, authenticate Student and redirect to test page
						Authentication authenticationToken = new UsernamePasswordAuthenticationToken(assgnmentObj.getStudentId(), accesscode);
						SecurityContextHolder.getContext().setAuthentication(authenticationToken);
						
						return "redirect:/showtest";
					}
				}else
					//If Student has not previously started, show page to select Categories
					return "redirect:/showcategories";
			}				
			
		}
		
		//throw error/access denied page
		return "redirect:/errorpage";
	}
	
	
	@RequestMapping(value="/setcategories", method=RequestMethod.POST)
	public void setCategories(@ModelAttribute("categoryDto") CategorySelectDto dto){
		//Use dto.getSelectedSubCategories() to get Categories selected by student and use it to generate Question Paper.
		//Generate Questions and return "showtest.jsp"
	}
	
	@RequestMapping(value="/showcategories", method=RequestMethod.GET)
	public String selectCategoriesView(Model model){
		
		CategorySelectDto dto = new CategorySelectDto();
		
		Iterator<Category> it = questionService.getAllCategories().iterator();
		List<Category> cats = Lists.newArrayList(it);
		
		dto.setCategories(cats);
		model.addAttribute("categoryDto", dto);	
		return "test/categoryselect";
	}

}
