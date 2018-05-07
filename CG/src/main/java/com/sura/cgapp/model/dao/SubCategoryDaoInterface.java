package com.sura.cgapp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sura.cgapp.model.entity.SubCategoryEntity;

@Repository
public interface SubCategoryDaoInterface extends PagingAndSortingRepository <SubCategoryEntity, Serializable>{
	
	@Query("select p from SubCategoryEntity p where p.name like %?1%")
	public List<SubCategoryEntity> findByName(String term);

}
