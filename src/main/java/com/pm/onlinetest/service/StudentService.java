package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Student;

 
public interface StudentService {

	public void save(Student student);
	public void delete(Student student);
	public List<Student> findAll();
	public Student findByStudentId(String studentId);
	public Student findByStudentId(Integer studentId);
}