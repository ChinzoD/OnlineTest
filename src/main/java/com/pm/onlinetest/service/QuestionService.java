package com.pm.onlinetest.service;

import org.springframework.stereotype.Service;

import com.pm.onlinetest.domain.Question;

@Service
public interface QuestionService {
	void create(Question book);
	void update(long id,Question book);
	void delete(long id);
}
