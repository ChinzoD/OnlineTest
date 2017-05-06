package com.pm.onlinetest.service;

import java.util.List;
import com.pm.onlinetest.domain.Choice;
import com.pm.onlinetest.domain.Question;
public interface ChoiceService {
public void save(Choice question);
public List<Choice> findAll();
public Choice findQuestionById(Integer id); 
public void delete(Choice choice);
public Choice getAnswer(Question question); 
	
}