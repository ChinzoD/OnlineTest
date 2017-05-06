package com.pm.onlinetest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.onlinetest.domain.Choice;
import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.repository.ChoiceRepository;
import com.pm.onlinetest.repository.QuestionRepository;
import com.pm.onlinetest.service.ChoiceService;
import com.pm.onlinetest.service.QuestionService;

@Service

public class ChoiceServiceImpl implements ChoiceService {
	@Autowired
	ChoiceRepository choiceRepository;

	@Override
	public void save(Choice question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Choice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Choice findQuestionById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Choice question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Choice getAnswer(Question question) {
		// TODO Auto-generated method stub
		return choiceRepository.getQuestionAnswer(question);
	}

	

}
