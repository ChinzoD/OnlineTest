package com.pm.onlinetest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pm.onlinetest.domain.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
	
}
