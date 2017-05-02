package com.pm.onlinetest.controller;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.Student;
import com.pm.onlinetest.domain.User;
import com.pm.onlinetest.service.AssignmentService;
import com.pm.onlinetest.service.CoachService;
import com.pm.onlinetest.service.StudentService;
import com.pm.onlinetest.service.UserService;

@Controller
@RequestMapping("/coach")
public class CoachController {

	@Autowired
	CoachService coachService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AssignmentService assignmentService;
	
	@Autowired
	StudentService studentService;
	
	
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		/*String coachName =  SecurityContextHolder.getContext().getAuthentication().getName();
		User coachModel = userService.findByUsername(coachName);
		Integer coachId = coachModel.getUserId();
*/
		List<Student> students = coachService.findStudentByAcitveJobStatus();
		model.addAttribute("students", students);
		return "coach";
	
	}
	
	
	@RequestMapping(value = "/home1", method = RequestMethod.POST)
	public String home1(Locale locale, Model model) {		
		/*String coachName =  SecurityContextHolder.getContext().getAuthentication().getName();
		User coachModel = userService.findByUsername(coachName);
		Integer coachId = coachModel.getUserId();
*/
		List<Student> students = coachService.findStudentByAcitveJobStatus();
		model.addAttribute("students", students);
		return "coach";
	
	}
	

	@RequestMapping(value = "/studentAssignmentDetail/{userId}", method = RequestMethod.GET)
	public String studentAssignmentDetail(@PathVariable("userId") String userId,Locale locale, Model model) {
		
		System.out.println("Student id in detail: "+userId);
		
		Integer studentId= Integer.parseInt(userId);
		Student student = coachService.findStudentById(studentId);
		model.addAttribute("student",student);
		return "studentAssignmentDetail";
	
	}
	
	
	
	@RequestMapping(value = "/studentAssignmentHistory/{userId}", method = RequestMethod.GET)
	public String studentAssignmentHistory(@PathVariable("userId") String userId,Locale locale, Model model) {
		Student student = studentService.findByStudentId(userId);
		List<Assignment> assignments = assignmentService.findByStudent(student);
		model.addAttribute("assignments",assignments);
		model.addAttribute("student",student);
		return "studentAssignmentHistory";
	
	}
	
	
	@RequestMapping(value = "/studentsNeededAssignment", method = RequestMethod.GET)
	public String studentsNeededAssignment(Locale locale, Model model) {
/*		String coachName =  SecurityContextHolder.getContext().getAuthentication().getName();
		User coachModel = userService.findByUsername(coachName);
		Integer coachId = coachModel.getUserId();

		System.out.println("Coach Id is:" + coachId);
		List<Student> students = coachService.findStudentsNeededAssignmentByCoach(coachId);
		if(students !=null){
			System.out.println("students not null");
			Iterator<Student> it =students.iterator();
	
			while(it.hasNext())
			System.out.println(it.next().getFirstName());
			
		}
		
		else {
			System.out.println("students null");
		}
		model.addAttribute("students",students);*/
		return "studentsNeededAssignment";
	
	}
	

	@RequestMapping(value = "/saveAssignment", method = RequestMethod.POST)
	public @ResponseBody String saveAssignment(RedirectAttributes redirectAttr,@RequestParam("userId") String userId,@RequestParam("accessLink") String accessLink,@RequestParam("accessCode") String accessCode) {		
		System.out.println("Student Id in save ASsignment is: "+userId);
		System.out.println("accesscode in save ASsignment is: "+accessCode);
		System.out.println("accessLink in save ASsignment is: "+accessLink);
		
		
		String coachName =  SecurityContextHolder.getContext().getAuthentication().getName();
		User coachModel = userService.findByUsername(coachName);
		System.out.println("coachModel.getUsername()t is: "+coachModel.getUsername());
		
		Student  student = studentService.findStudentById(Integer.parseInt(userId));
		System.out.println("student.getUsername() is: "+student.getUsername());
		
		Assignment assignment = new Assignment();
		assignment.setAccesscode(accessCode);
		assignment.setCoachId(coachModel);
		assignment.setStudentId(student);
		assignment.setCount(0);
		assignment.setStart_date(LocalDateTime.now());
		assignment.setEnd_date(LocalDateTime.now());
		assignment.setFinished(false);
		
		System.out.println(" Assignment get access codeis: "+assignment.getAccesscode());
		
		assignmentService.saveAssignment(assignment);
	/*	redirectAttr.addFlashAttribute("success", "Test Generated Successfully!");
	   	return "redirect:/coach/home";
*/
		return "success";
	}
	
 
}
