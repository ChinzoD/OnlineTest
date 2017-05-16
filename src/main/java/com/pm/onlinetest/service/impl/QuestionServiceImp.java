package com.pm.onlinetest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Subcategory;
import com.pm.onlinetest.repository.QuestionRepository;
import com.pm.onlinetest.service.QuestionService;

@Service
/**
* The Question service implementation have used to add,update and delelte question and its corresponding choices and answers
* It also used to for shared by  other modules .
*
* @author  Birhanu Gebresenbet
* @version 1.0
* @since   2017-03-31 
*/
public class QuestionServiceImp implements QuestionService {
	@Autowired
	QuestionRepository questionRepository;

	@Override
	public void save(Question question) {
		questionRepository.save(question);
	}

	@Override
	public List<Question> findAll() {
		return (List<Question>) questionRepository.findAll();
	}

	@Override
	public Question findQuestionById(Integer id) {
		return questionRepository.findOne(id);
	}

	@Override
	public void delete(Question question) {
		questionRepository.delete(question);
	}

	@Override
	public List<Question> findBySubcategory(Subcategory subcategory) {
		List<Question> questions = questionRepository.findBySubcategory(subcategory);
		return questions;
	}

	@Override
	public void update(Question question) {
		questionRepository.save(question);
		
	}

}
