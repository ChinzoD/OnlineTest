package com.pm.onlinetest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.repository.QuestionRepository;
import com.pm.onlinetest.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImp implements QuestionService {

	@Override
	public void create(Question book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, Question book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
//	@Autowired
//	QuestionRepository questionRepository;
//
//	@Override
//	public void create(Question question) {
//		questionRepository.save(question);
//
//	}
//
//	@Override
//	public void update(long id, Question question) {
//	// questionRepository...updateQuestion(question);
//
//	}
//
//	@Override
//	public void delete(long id) {
//	
//
//	}

}
