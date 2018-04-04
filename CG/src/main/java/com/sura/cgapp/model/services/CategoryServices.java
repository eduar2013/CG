package com.sura.cgapp.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sura.cgapp.model.dao.CategoryDaoInterface;
import com.sura.cgapp.model.entity.CategoryEntity;

@Service
public class CategoryServices {
	
	@Autowired
	private CategoryDaoInterface categoryDao;
	
	public List<CategoryEntity> findAll(){
		return (List<CategoryEntity>)categoryDao.findAll();
	}
	
	public CategoryEntity findOne(Integer id) {
		return categoryDao.findOne(id);		
	}
	
	public void save(CategoryEntity categoryEntity) {
		categoryDao.save(categoryEntity);
	}
	
	public void delete(Integer id) {
		categoryDao.delete(findOne(id));
	}
}
