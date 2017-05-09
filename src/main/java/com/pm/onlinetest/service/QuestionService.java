package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Question;

public interface QuestionService {
	public void save(Question question);
	public void update(Question question);

	public List<Question> findAll();

	public Question findQuestionById(Integer id);

	public void delete(Question question);

}