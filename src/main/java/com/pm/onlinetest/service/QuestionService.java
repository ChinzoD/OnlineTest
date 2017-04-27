package com.pm.onlinetest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Question;

public interface QuestionService {
	public void save(Question question);

	
	
}