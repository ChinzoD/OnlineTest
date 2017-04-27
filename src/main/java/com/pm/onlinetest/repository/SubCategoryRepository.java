package com.pm.onlinetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pm.onlinetest.domain.Subcategory;


@Repository
public interface SubCategoryRepository extends CrudRepository<Subcategory, Integer> {
	

    	 @Query("from Subcategory sc join sc.category c  where c.id=:catId)")
	    public List<Subcategory> findSubCategoryById(@Param("catId") Integer catId);
	
	 
}
