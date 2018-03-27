package com.sura.cgapp.model.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sura.cgapp.model.dao.CategoryDaoInterface;
import com.sura.cgapp.model.entity.CategoryEntity;

@Repository
public class CategoryDaoImp implements CategoryDaoInterface{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<CategoryEntity> categoryFindAll() {
		return em.createQuery("from CategoryEntity").getResultList();
	}

}
