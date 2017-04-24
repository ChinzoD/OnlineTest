package com.pm.onlinetest.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pm.onlinetest.domain.User;
import com.pm.onlinetest.domain.Authority;
import com.pm.onlinetest.domain.Student;
import com.pm.onlinetest.service.AuthorityService;
import com.pm.onlinetest.service.StudentService;
import com.pm.onlinetest.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	UserService userService;
	@Autowired
	AuthorityService authorityService;
	@Autowired
	StudentService studentService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "admin-home";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(Locale locale, Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "users";
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
	   	return "redirect:/admin/register";
	}
	
	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public void DeletePost(HttpServletRequest request) {
		String id = request.getParameter("userid").toString();
		User user = userService.findByUserId(Integer.parseInt(id));
		userService.delete(user);
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String getStudents(Locale locale, Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("student", students);
		return "students";
	}
}
