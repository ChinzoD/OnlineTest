package com.pm.onlinetest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pm.onlinetest.domain.User;
import com.pm.onlinetest.domain.Authority;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Choice;
import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Student;
import com.pm.onlinetest.domain.Subcategory;
import com.pm.onlinetest.service.AuthorityService;
import com.pm.onlinetest.service.CategoryService;
import com.pm.onlinetest.service.ChoiceService;
import com.pm.onlinetest.service.QuestionService;
import com.pm.onlinetest.service.StudentService;
import com.pm.onlinetest.service.SubCategoryService;
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
	@Autowired
	CategoryService categoryService;
	@Autowired
	SubCategoryService subCategoryService;
	@Autowired
	QuestionService questionService;
	@Autowired
	ChoiceService choiceService;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "admin-home";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(Locale locale, Model model) {
		List<User> users = userService.findAllEnabled();
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

		if(null != userService.findByUsername(user.getUsername())){
			redirectAttr.addFlashAttribute("msgType", "Error");
		}else{
			user.setEnabled(true);
			userService.save(user);
			redirectAttr.addFlashAttribute("msgType", "Success");			
		}
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
		if(null != studentService.findByStudentId(student.getStudentId())){
			redirectAttr.addFlashAttribute("msgType", "Error");
		}else{
			studentService.save(student);
			redirectAttr.addFlashAttribute("msgType", "Success");		
		}
		return "redirect:/admin/registerStudent";
	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public void DeleteUser(HttpServletRequest request) {
		String id = request.getParameter("userid").toString();
		userService.softDelete(Integer.parseInt(id));		
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String getStudents(Model model) {
		List<Student> students = studentService.findAllEnabled();
		model.addAttribute("students", students);
		return "students";
	}

	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public String assignCoach(Model model) {
		List<Student> students = studentService.findAll();
		List<User> coaches = userService.findByAuthority("ROLE_COACH");

		model.addAttribute("students", students);
		model.addAttribute("coaches", coaches);

		return "assignCoach";
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String getCategory(Model model) {
		List<Category> categories = categoryService.findAllEnabled();
		model.addAttribute("categories", categories);
		return "categories";
	}
	
	@RequestMapping(value = "/createCategory", method = RequestMethod.GET)
	public String createCategory(@ModelAttribute("Category") Category category) {
		return "createCategory";
	}
	
	@RequestMapping(value = "/createCategory", method = RequestMethod.POST)
	public String createCategoryPost(@ModelAttribute("Category") Category category, BindingResult result,
			RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return "createCategory";
		}
		
		categoryService.save(category);
		redirectAttr.addFlashAttribute("success", "Successfully added new category!");
		return "redirect:/admin/createCategory";
	}
	
	@RequestMapping(value = "/subCategories", method = RequestMethod.GET)
	public String getSubCategory(Model model) {
		List<Subcategory> subCategories = subCategoryService.findAllEnabled();
		model.addAttribute("subCategories", subCategories);
		return "subCategories";
	}
	
	@RequestMapping(value = { "/deleteCategory" }, method = RequestMethod.POST)
	public void DeleteCategory(HttpServletRequest request) {
		String id = request.getParameter("id").toString();
		categoryService.softDelete(Integer.parseInt(id));		
	}
	
	@RequestMapping(value = "/createSubCategory", method = RequestMethod.GET)
	public String createSubCategory(@ModelAttribute("Subcategory") Subcategory subcategory, Model model) {
		List<Category> categories = categoryService.findAllEnabled();
		model.addAttribute("categories", categories);
		return "createSubCategory";
	}
	
	@RequestMapping(value = "/createSubCategory", method = RequestMethod.POST)
	public String createSubCategoryPost(@ModelAttribute("Subcategory") Subcategory subcategory, BindingResult result,
			RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return "createSubCategory";
		}
		
		subcategory.setCategory(categoryService.findOne(subcategory.getCategoryId()));
		subCategoryService.save(subcategory);
		redirectAttr.addFlashAttribute("success", "Successfully added new Subcategory!");
		return "redirect:/admin/createSubCategory";
	}
	
	@RequestMapping(value = { "/deleteSubCategory" }, method = RequestMethod.POST)
	public void DeleteSubCategory(HttpServletRequest request) {
		String id = request.getParameter("id").toString();
		subCategoryService.softDelete(Integer.parseInt(id));		
	}
		
	@RequestMapping(value = "/importData", method = RequestMethod.GET)
	public String importDataGet() {
		return "importData";
	}
	
	@RequestMapping(value = "/importData", method = RequestMethod.POST)
	public String processExcel2007(Model model, @RequestParam("ExcelFile") MultipartFile excelfile, RedirectAttributes redirectAttr) {		
		try {
			List<Question> questions = new ArrayList<>();
			int i = 0;
			// Creates a workbook object from the uploaded excelfile
			XSSFWorkbook workbook = new XSSFWorkbook(excelfile.getInputStream());
			// Creates a worksheet object representing the first sheet
			XSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			while (i <= worksheet.getLastRowNum()) {
				Question question = new Question();
				List<Choice> choices = new ArrayList<>();
				
				XSSFRow row = worksheet.getRow(i++);
				
				question.setDescription(row.getCell(0).getStringCellValue());
				
				String catName = row.getCell(8).getStringCellValue().trim();
				String subCatName = row.getCell(9).getStringCellValue().trim();
				boolean error = false;
				for(int j= 0; j<10; j++){
					if(row.getCell(j).getStringCellValue().trim().length() == 0){
						error = false;
						redirectAttr.addFlashAttribute("error2", "");
					}
					if(j == 7){
						String answer = row.getCell(j).getStringCellValue().toUpperCase();
						if(65 > answer.charAt(0) || 70 < answer.charAt(0)){
							error = false;
							redirectAttr.addFlashAttribute("error2", "Please check answer column.");
						}
					}
					if(error){
						redirectAttr.addFlashAttribute("msgType", "Error");
						redirectAttr.addFlashAttribute("error1", "Error on line: "+i);
						return "redirect:/admin/importData";
					}
				}

				
				List<Subcategory> subcategories = subCategoryService.findSubCategoryByName(subCatName);
				if(subcategories.size() == 0){
					Subcategory subCategory = new Subcategory();
					subCategory.setName(subCatName);
					subCategory.setEnabled(true);
					
					List<Category> categories = categoryService.findCategoryByName(subCatName);
					if(categories.size() == 0){
						Category category = new Category();
						category.setName(catName);
						category.setEnabled(true);
						categoryService.save(category);
						subCategory.setCategory(category);
					}else{
						subCategory.setCategory(categories.get(0));
					}
					subCategoryService.save(subCategory);
					question.setSubcategory(subCategory);
				}else{
					question.setSubcategory(subcategories.get(0));
				}

				questionService.save(question);
				String answer = row.getCell(7).getStringCellValue().toUpperCase();
				int correctAnswerPos = answer.charAt(0) - 65;
				
				for(int k=1; k < 7; k++){
					Choice choice = new Choice();
					choice.setQuestion(question);
					choice.setDescription(row.getCell(k).getStringCellValue().trim());
					if(correctAnswerPos == k){
						choice.setAnswer(true);
					}else{
						choice.setAnswer(false);
					}
					choices.add(choice);
				}
				choiceService.save(choices);
				
			}			
			workbook.close();
			redirectAttr.addFlashAttribute("msgType", "Success");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttr.addFlashAttribute("msgType", "Error");
			redirectAttr.addFlashAttribute("error2", "Error:\n\n"+e);
		}
		
		return "redirect:/admin/importData";
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
