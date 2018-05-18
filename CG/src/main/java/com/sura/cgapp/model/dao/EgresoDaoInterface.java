package com.sura.cgapp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sura.cgapp.model.entity.Egreso;

@Repository
public interface EgresoDaoInterface  extends PagingAndSortingRepository<Egreso, Serializable>{

	List<Egreso> findByOrderByIdDesc();

}
