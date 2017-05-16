package com.pm.onlinetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pm.onlinetest.domain.Question;
import com.pm.onlinetest.domain.Subcategory;

/**
* The Question repository have used to add,update and delelte question and its corresponding choices and answers
* It also used to for shared by  other modules .
*
* @author  Birhanu Gebresenbet
* @version 1.0
* @since   2017-03-31 
*/
@Repository

public interface QuestionRepository extends CrudRepository<Question, Integer>{
//	 @Modifying
//	    @Query("UPDATE Question q set q.description=:description WHERE q.id = :questionId")
//int  updateQuestion(@Param("questionId") int questionId);
	 
 
	
	public Question findById(Integer id);
	public Question getQuestionById(int id);

	@Query("SELECT q FROM Question q WHERE q.subcategory=:subcategory")
	List<Question> findBySubcategory(@Param("subcategory") Subcategory subcategory);


}
