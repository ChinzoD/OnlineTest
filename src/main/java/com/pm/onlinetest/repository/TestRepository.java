package com.pm.onlinetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pm.onlinetest.domain.Test;

/**
 * Repository interface for Report model/domain
 * @author wei.zhou
 */
public interface TestRepository extends CrudRepository<Test, Integer>{
	
	@Query("SELECT t FROM Test t WHERE t.id =:testId")
	Test findByTestId(@Param("testId") Integer testId);
	
	@Query("SELECT * FROM Test")
	List<Test> getAllTests();
	
	
	
}