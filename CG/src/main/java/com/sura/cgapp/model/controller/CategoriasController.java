package com.sura.cgapp.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sura.cgapp.model.dao.CategoryDaoInterface;
import com.sura.cgapp.model.entity.CategoryEntity;

@Controller
public class CategoriasController {
	
	@Autowired
	private CategoryDaoInterface categoryDao;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model model) {		
		model.addAttribute("listCategories", categoryDao.findAll());
		return "categorias";
	}
	
	@GetMapping("/newCategory")
	public String newCategory(Model model) {
		model.addAttribute("category",new CategoryEntity());
		return "nuevaCategoria";
	}
	
	@PostMapping("/newCategory")
	public String createCategory(CategoryEntity categoryEntity) {		
		categoryDao.save(categoryEntity);
		return "redirect:categorias";
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminarCategoria(@PathVariable(value="id") Integer id) {
		CategoryEntity c = categoryDao.findOne(id);		
		categoryDao.delete(c);
		return "redirect:/categorias";
	}
}
