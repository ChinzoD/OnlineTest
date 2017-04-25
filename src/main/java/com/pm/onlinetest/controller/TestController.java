package com.pm.onlinetest.controller;

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
		return "access";
	}
	
	@RequestMapping(value="/access", method=RequestMethod.POST)
	public String verifyAccess(@RequestParam("access_code") String accesscode, RedirectAttributes attr){
		
		System.out.println(accesscode);
		
		Assignment assgnmentObj;
		
		if ((assgnmentObj = testService.getAssignment(accesscode)) != null){
			//Authenticate Student and navigate to test categories page
			
			Authentication authenticationToken = new UsernamePasswordAuthenticationToken(assgnmentObj.getStudentId(), accesscode);
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			
			attr.addFlashAttribute("assignment", assgnmentObj);
			return "redirect:/showcategories";
			
		}else{
			//throw error/access denied page
			return "redirect:/errorpage";
		}
	}
	
	
	@RequestMapping(value="/setcategories", method=RequestMethod.POST)
	public void setCategories(@ModelAttribute("categoryDto") CategorySelectDto dto){
		for (String c : dto.getSelectedSubCategories()){
			System.out.println(c);
		}
		//Generate Questions and return "showtest.jsp"
	}
	
	@RequestMapping(value="/showcategories", method=RequestMethod.GET)
	public String selectCategoriesView(Model model){
		
		CategorySelectDto dto = new CategorySelectDto();
		
		Iterator<Category> it = questionService.getAllCategories().iterator();
		List<Category> cats = Lists.newArrayList(it);
		
		dto.setCategories(cats);
		model.addAttribute("categoryDto", dto);	
		return "categoryselect";
	}

}
