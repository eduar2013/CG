package com.sura.cgapp.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sura.cgapp.model.dao.CategoryDaoInterface;
import com.sura.cgapp.model.dao.SubCategoryDaoInterface;
import com.sura.cgapp.model.entity.CategoryEntity;
import com.sura.cgapp.model.entity.SubCategoryEntity;

@Service
public class SubCategoryServices {
	
	@Autowired
	SubCategoryDaoInterface subCategoryDaoInterface;
	
	@Autowired
	CategoryDaoInterface categoryDaoInterface;
	
	public SubCategoryEntity findOne(Integer id) {
		return subCategoryDaoInterface.findOne(id);
	}
	
	public List<SubCategoryEntity> findAll(){
		return (List<SubCategoryEntity>) subCategoryDaoInterface.findAll();
	}
	
	public Page<SubCategoryEntity> findAll(Pageable pageable){
		return subCategoryDaoInterface.findAll(pageable);
	}
	
	public void save(SubCategoryEntity subCategoryEntity) {
		subCategoryDaoInterface.save(subCategoryEntity);
	}
	
	public void delete(Integer id) {
		subCategoryDaoInterface.delete(findOne(id));
	}
	
	public List<CategoryEntity> getCategory() {
		return  (List<CategoryEntity>)categoryDaoInterface.findAll();
	}
	
	public List<CategoryEntity> findByName(String term) {
		return  categoryDaoInterface.findByName(term);
	}
}
