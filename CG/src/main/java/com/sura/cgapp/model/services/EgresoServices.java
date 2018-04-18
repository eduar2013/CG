package com.sura.cgapp.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sura.cgapp.model.dao.EgresoDaoInterface;

@Service
public class EgresoServices {
	
	@Autowired
	EgresoDaoInterface egresoDao;
	
	

}
