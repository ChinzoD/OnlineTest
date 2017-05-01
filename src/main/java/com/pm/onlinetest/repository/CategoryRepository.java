package com.pm.onlinetest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pm.onlinetest.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
