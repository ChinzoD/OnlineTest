package com.pm.onlinetest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Question;

@Service
public interface QuestionService {
	void create(Question book);
	void update(long id,Question book);
	void delete(long id);
	Iterable<Category> getAllCategories();
}
