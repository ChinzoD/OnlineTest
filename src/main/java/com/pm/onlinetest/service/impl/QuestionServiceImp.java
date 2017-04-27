package com.pm.onlinetest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.repository.QuestionRepository;
import com.pm.onlinetest.service.QuestionService;

@Service

public class QuestionServiceImp implements QuestionService {
	@Autowired
	QuestionRepository questionRepository;

	@Override
	public void save(Question question) {

		questionRepository.save(question);

	}

}
