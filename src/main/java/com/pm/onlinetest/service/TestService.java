package com.pm.onlinetest.service;

import org.springframework.stereotype.Service;

import com.pm.onlinetest.domain.Assignment;

public interface TestService {
	
	Assignment getAssignment(String accesscode);
	
}
