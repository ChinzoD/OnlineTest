package com.pm.onlinetest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.service.AssignmentService;
import com.pm.onlinetest.service.CategoryService;
import com.pm.onlinetest.service.QuestionService;
import com.pm.onlinetest.service.TestService;

import helpers.CategorySelectDto;

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

	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String showAccessPage(){
		return "access";
	}
	
	@RequestMapping(value="/access", method=RequestMethod.POST)
	public String verifyAccess(@RequestParam("access_code") String accesscode, RedirectAttributes attr){
		
		System.out.println(accesscode);
		
		Assignment assgnmentObj;
		
		//Check if Student has been assigned a test using the supplied Access Code
		if ((assgnmentObj = testService.getAssignment(accesscode)) != null){
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
	
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String setCategories(@ModelAttribute("categoryDto") CategorySelectDto dto, BindingResult resultDto,
			HttpServletRequest request, @ModelAttribute("ass_Id") final Integer ass_Id){
		//Use dto.getSelectedSubCategories() to get Categories selected by student and use it to generate Question Paper.
		//Generate Questions and return "showtest.jsp"
		//
		return null;
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String selectCategoriesView(Model model, HttpServletRequest request, RedirectAttributes attr){
		
		Assignment obj = (Assignment) request.getAttribute("assignment");
		
		if (obj == null){
			attr.addFlashAttribute("errormessage", "Invalid Operation");
			return "redirect:/test/error";
		}
		
		CategorySelectDto dto = new CategorySelectDto();
		Iterator<Category> it = categoryService.getAllCategories().iterator();
		List<Category> cats = Lists.newArrayList(it);
		
		dto.setCategories(cats);
		model.addAttribute("categoryDto", dto);	
		return "test/categoryselect";
	}
	
	@RequestMapping(value = "/showtest", method = RequestMethod.GET)
	public String test(ModelMap model, @ModelAttribute("ass_Id") final Integer ass_Id) {

		return "test/testpage";
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

}
