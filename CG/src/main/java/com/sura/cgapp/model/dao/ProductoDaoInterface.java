package com.sura.cgapp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sura.cgapp.model.entity.Producto;

@Repository
public interface ProductoDaoInterface extends CrudRepository<Producto,Serializable>{
	
	@Query("select p from Producto p where name like %?1%")
	public List<Producto> findByName(String term);

}
