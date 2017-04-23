package com.pm.onlinetest.controller;

import java.util.List;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pm.onlinetest.domain.User;
import com.pm.onlinetest.domain.Authority;
import com.pm.onlinetest.service.UserService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/rolecheck", method = RequestMethod.GET)
	public String roleCheck(Locale locale, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    User user = userService.findByUsername(name);

	    for(Authority authority: user.getAuthorities()){
	    	if(authority.getAuthority().equals("ROLE_ADMIN")){
	    		return "/admin-home";
	    	}else if(authority.getAuthority().equals("ROLE_COACH")){
	    		return "/coach-home";
	    	}else if(authority.getAuthority().equals("ROLE_DBA")){
	    		return "/dba-home";
	    	}
	    }
	    return "home";
	}
	
}
