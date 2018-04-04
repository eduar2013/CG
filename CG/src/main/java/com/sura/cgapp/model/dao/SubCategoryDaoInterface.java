package com.sura.cgapp.model.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sura.cgapp.model.entity.SubCategoryEntity;

@Repository
public interface SubCategoryDaoInterface extends CrudRepository<SubCategoryEntity, Serializable>{

}
