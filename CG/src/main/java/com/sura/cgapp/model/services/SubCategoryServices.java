package com.sura.cgapp.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sura.cgapp.model.dao.SubCategoryDaoInterface;
import com.sura.cgapp.model.entity.CategoryEntity;
import com.sura.cgapp.model.entity.SubCategoryEntity;

@Service
public class SubCategoryServices {
	
	@Autowired
	SubCategoryDaoInterface subCategoryDaoInterface;
	
	public List<SubCategoryEntity> findAll(){
		return (List<SubCategoryEntity>) subCategoryDaoInterface.findAll();
	}
	
	public void save(SubCategoryEntity subCategoryEntity) {
		subCategoryDaoInterface.save(subCategoryEntity);
	}
	
	
	public List<CategoryEntity> getCategory() {
		List<CategoryEntity> categoriasList = new ArrayList<>();
		
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(1);
		categoryEntity.setName("casa");		
		categoriasList.add(categoryEntity);
		
		categoryEntity = new CategoryEntity();
		categoryEntity.setId(2);
		categoryEntity.setName("Auto");
		
		categoriasList.add(categoryEntity);
		
		categoryEntity = new CategoryEntity();
		categoryEntity.setId(3);
		categoryEntity.setName("Educacion");
		
		categoriasList.add(categoryEntity);
		
		return categoriasList;
	}
}
