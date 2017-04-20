package com.pm.onlinetest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pm.onlinetest.domain.User;
import com.pm.onlinetest.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("loginUser") User user) {
 		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("loginUser") User user, BindingResult result, 
			RedirectAttributes redirectAttr) {
		if(result.hasErrors()) {
			return "register";
		}
		
		userService.save(user);
		redirectAttr.addFlashAttribute("success", "Successfully added new user!");
	   	return "redirect:/register";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(@ModelAttribute("loginUser") User user, Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
 		return "redirect:/login";
 	}
}
