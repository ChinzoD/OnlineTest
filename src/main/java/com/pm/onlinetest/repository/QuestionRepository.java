package com.pm.onlinetest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>{
	
}
