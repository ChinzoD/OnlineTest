package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.Student;

public interface AssignmentService {

	public String generateAccesscode();
	public Boolean isExist(String accesscode);
	public List<Assignment> findByStudent(Student student);
	public void saveAssignment(Assignment assignment);
	public void updateAccessCount(Assignment assignment);
	
	//add by Joy start
	// get Student
	Student getStudentById(String studentId);
	
	// get Coach
	//get Assignment
	public Assignment findById(Integer id);
	
	public List<Assignment> findAll();
	//add by Joy end
}
