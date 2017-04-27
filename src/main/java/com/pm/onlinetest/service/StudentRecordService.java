package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Student_Record;
 
public interface StudentRecordService {

	public void save(Student_Record studentRecord);
	public void delete(Student_Record studentRecord);
	public List<Student_Record> findAll();
	public Student_Record findById(Integer Id);
 }
