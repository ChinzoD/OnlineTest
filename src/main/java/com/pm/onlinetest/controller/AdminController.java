package com.pm.onlinetest.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "admin-home";
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(Locale locale, Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("loginUser") User user) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("loginUser") User user, BindingResult result,
			RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return "register";
		}

		userService.save(user);
		redirectAttr.addFlashAttribute("success", "Successfully added new user!");
		return "redirect:/admin/register";
	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.GET)
	public String getStudent(@ModelAttribute("loginUser") Student student) {
		return "registerStudent";
	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	public String registerStudent(@ModelAttribute("loginUser") Student student, BindingResult result,
			RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return "registerStudent";
		}

		studentService.save(student);
		redirectAttr.addFlashAttribute("success", "Successfully added new user!");
		return "redirect:/admin/registerStudent";
	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public void DeleteUser(HttpServletRequest request) {
		String id = request.getParameter("userid").toString();
		User user = userService.findByUserId(Integer.parseInt(id));
		userService.delete(user);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String getStudents(Locale locale, Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "students";
	}

	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public String assignCoach(Locale locale, Model model) {
		List<Student> students = studentService.findAll();
		List<User> coaches = userService.findByAuthority("ROLE_COACH");

		model.addAttribute("students", students);
		model.addAttribute("coaches", coaches);

		return "assignCoach";
	}

//	@ResponseBody
//	@RequestMapping(value = "/assign", method = RequestMethod.POST)
//	public String getAssignCoach(Locale locale, Model model, HttpServletRequest request,
//			RedirectAttributes redirectAttr) {
//		String coachId = request.getParameter("coachId").toString();
//		String studentId = request.getParameter("studentId").toString();
//		User coach = userService.findByUserId(Integer.parseInt(coachId));
//		Student student = studentService.findByStudentId(studentId);
//		Student_Record studentRecord = new Student_Record();
//		studentRecord.setCoach(coach);
//		studentRecord.setStudent(student);
//		studentRecordService.save(studentRecord);
//
//		// redirectAttr.addFlashAttribute("success", "Successfully assigned!");
//		// return "assigned";
//		return "ok";
//	}

//	@RequestMapping(value = "/assignedList", method = RequestMethod.GET)
//	public String getAssignedList(Locale locale, Model model) {
//		List<Student_Record> studentRecords = studentRecordService.findAll();
//		model.addAttribute("studentRecords", studentRecords);
//		return "assignedList";
//	}
//
//	@RequestMapping(value = { "/deleteAssign" }, method = RequestMethod.POST)
//	public void DeleteAssign(HttpServletRequest request) {
//		String id = request.getParameter("userid").toString();
//		Student_Record sr = studentRecordService.findById(Integer.parseInt(id));
//		studentRecordService.delete(sr);
//	}
}
