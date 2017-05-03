package com.pm.onlinetest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pm.onlinetest.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	

	@Query("SELECT s FROM Student s WHERE s.studentId =:studentId")
	Student findByStudentId(@Param("studentId") String studentId);
}
