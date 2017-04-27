package com.pm.onlinetest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.onlinetest.domain.Student_Record;
import com.pm.onlinetest.repository.StudentRecordRepository;
import com.pm.onlinetest.service.StudentRecordService;

@Service
@Transactional
public class StudentRecordServiceImpl implements StudentRecordService {

	@Autowired
	private StudentRecordRepository studentRecordRepository;

	@Override
	public void save(Student_Record studentRecord) {
		// TODO Auto-generated method stub
		studentRecordRepository.save(studentRecord);
	}

	@Override
	public void delete(Student_Record studentRecord) {
		// TODO Auto-generated method stub
		studentRecordRepository.delete(studentRecord);
	}

	@Override
	public List<Student_Record> findAll() {
		// TODO Auto-generated method stub
		return (List<Student_Record>) studentRecordRepository.findAll();
	}

	@Override
	public Student_Record findById(Integer id) {
		// TODO Auto-generated method stub
		return studentRecordRepository.findById(id);
	}

	
}
