package com.sura.cgapp.model.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sura.cgapp.model.entity.CategoryEntity;

@Repository
public interface CategoryDaoInterface extends CrudRepository<CategoryEntity, Serializable>{
	
	
}
