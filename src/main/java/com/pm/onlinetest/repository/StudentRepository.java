package com.pm.onlinetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pm.onlinetest.domain.Student;
import com.pm.onlinetest.domain.User;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	@Query("SELECT s FROM Student s WHERE s.studentId =:studentId")
	Student findByStudentId(@Param("studentId") String studentId);
	
	@Query("SELECT s FROM User u, Student s WHERE s.userId = u.userId AND u.enabled = true")
	List<Student> findAllEnabled();
}
