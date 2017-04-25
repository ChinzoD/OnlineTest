package com.pm.onlinetest.service;

import com.pm.onlinetest.domain.Assignment;

public interface TestService {
	
	Assignment getAssignment(String accesscode);
	
}
