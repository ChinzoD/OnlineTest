package com.pm.onlinetest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pm.onlinetest.domain.Assignment;
import com.pm.onlinetest.domain.User;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer>{
	
	@Query("SELECT a FROM Assignment a WHERE a.accesscode = :accesscode")
	Assignment getAssignment(@Param("accesscode") String accesscode);
	
	/*@Query("SELECT u FROM User u WHERE u.username =:username")
	Assignment findByStartDate(@Param("username") String username);*/
}
