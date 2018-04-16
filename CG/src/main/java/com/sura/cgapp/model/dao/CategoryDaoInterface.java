package com.sura.cgapp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sura.cgapp.model.entity.CategoryEntity;

@Repository
public interface CategoryDaoInterface extends CrudRepository<CategoryEntity, Serializable>{
	
	@Query("select p from CategoryEntity p where p.name like %?1%")
	public List<CategoryEntity> findByName(String term);
}
