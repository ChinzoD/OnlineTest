package com.pm.onlinetest.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pm.onlinetest.domain.Student_Record;

public interface StudentRecordRepository extends CrudRepository<Student_Record, Integer>{
	
	@Query("SELECT sr FROM Student_Record sr WHERE sr.id =:id")
	Student_Record findById(@Param("id") Integer id);

}
