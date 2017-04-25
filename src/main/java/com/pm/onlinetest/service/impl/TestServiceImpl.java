package com.pm.onlinetest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.repository.AssignmentRepository;
import com.pm.onlinetest.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	AssignmentRepository assignmentRepository;
	
	@Override
	public Assignment getAssignment(String accesscode) {
		// TODO Auto-generated method stub
		return assignmentRepository.getAssignment(accesscode);
		
	}

}
