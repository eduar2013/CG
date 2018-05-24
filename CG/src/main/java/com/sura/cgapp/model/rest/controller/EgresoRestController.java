package com.sura.cgapp.model.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sura.cgapp.model.entity.Egreso;
import com.sura.cgapp.model.services.EgresoServices;

@RestController
@RequestMapping("/api/rest")
public class EgresoRestController {
	
	@Autowired
	EgresoServices egresoServices;
	
	@GetMapping("/listar")
	public List<Egreso> listar(){		
		return egresoServices.findAll();
	}

}
