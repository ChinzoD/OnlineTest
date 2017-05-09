package com.pm.onlinetest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pm.onlinetest.domain.Grading;

@Repository
public interface GradingRepository extends CrudRepository<Grading, Integer> {
	
	@Query("SELECT g.value FROM Grading g WHERE g.fromScale >=:score ")
	String findGrade(@Param("score") double score);
}
