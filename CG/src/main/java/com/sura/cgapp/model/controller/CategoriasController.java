package com.sura.cgapp.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sura.cgapp.model.dao.CategoryDaoInterface;
import com.sura.cgapp.model.entity.CategoryEntity;

@Controller
public class CategoriasController {
	
	@Autowired
	private CategoryDaoInterface categoryDao;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model model) {		
		model.addAttribute("listCategories", categoryDao.categoryFindAll());
		return "categorias";
	}
	
	@GetMapping("/newCategory")
	public String newCategory(Model model) {
		model.addAttribute("category",new CategoryEntity());
		return "nuevaCategoria";
	}
	
	@PostMapping("/newCategory")
	public String createCategory(Model model) {
		model.addAttribute("category",new CategoryEntity());
		return "nuevaCategoria";
	}
}
