package com.pm.onlinetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pm.onlinetest.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
//	 @Modifying
//	    @Query("UPDATE Question q set q.description=:description WHERE q.id = :questionId")
//int  updateQuestion(@Param("questionId") int questionId);
	 
 
}
