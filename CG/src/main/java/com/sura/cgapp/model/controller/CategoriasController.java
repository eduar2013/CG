package com.sura.cgapp.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sura.cgapp.model.dao.CategoryDaoInterface;

@Controller
public class CategoriasController {
	
	@Autowired
	private CategoryDaoInterface categoryDao;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model model) {		
		model.addAttribute("listCategories", categoryDao.categoryFindAll());
		return "categorias";
	}
}
