package com.sura.cgapp.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sura.cgapp.model.dao.SubCategoryDaoInterface;
import com.sura.cgapp.model.entity.SubCategoryEntity;

@Service
public class SubCategoryServices {
	
	@Autowired
	SubCategoryDaoInterface subCategoryDaoInterface;
	
	public List<SubCategoryEntity> findAll(){
		return (List<SubCategoryEntity>) subCategoryDaoInterface.findAll();
	}
}
