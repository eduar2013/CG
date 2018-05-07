package com.sura.cgapp.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sura.cgapp.model.dao.EgresoDaoInterface;
import com.sura.cgapp.model.entity.Egreso;

@Service
public class EgresoServices{
	
	@Autowired
	EgresoDaoInterface egresoDao;
	
	public List<Egreso> findAll(){
		return (List<Egreso>) egresoDao.findByOrderByIdDesc();
	}
	
	public void grabarEgreso(Egreso egreso) {
		egresoDao.save(egreso);
	}
}