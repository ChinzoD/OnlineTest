package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Subcategory;
/**
* The Question service interfce have used to add,update and delelte question and its corresponding choices and answers
* It also used to for shared by  other modules .
*
* @author  Birhanu Gebresenbet
* @version 1.0
* @since   2017-03-31 
*/
public interface QuestionService {
	
	public void save(Question question);
	public void update(Question question);
	public List<Question> findAll();
	public Question findQuestionById(Integer id);
	public void delete(Question question);
	public List<Question> findBySubcategory(Subcategory subcategory);
}
