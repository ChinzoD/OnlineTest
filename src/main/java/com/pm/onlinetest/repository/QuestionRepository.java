package com.pm.onlinetest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pm.onlinetest.domain.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>{
	public Question findById(Integer id );
	//public void save(Question q);
	//public void addQuestion(Question q);
//	public void updateQuestion(Question q );
	public List<Question> listPersons();
	public Question getQuestionById(int id);
}
