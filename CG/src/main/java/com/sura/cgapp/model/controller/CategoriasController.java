package com.sura.cgapp.model.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.sura.cgapp.model.entity.CategoryEntity;
import com.sura.cgapp.model.services.CategoryServices;

@Controller
@SessionAttributes("categoryEntity")
public class CategoriasController {
	
	@Autowired
	private CategoryServices categoryServices;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model model) {
		model.addAttribute("title","Categorias");
		model.addAttribute("listCategories", categoryServices.findAll());
		return "categorias";
	}
	
	@GetMapping("/newCategory")
	public String newCategory(Model model) {
		model.addAttribute("category",new CategoryEntity());
		model.addAttribute("title","Nueva Categoria");
		return "nuevaCategoria";
	}
	
	@PostMapping("/newCategory")
	public String createCategory(@Valid CategoryEntity categoryEntity, Model model, @RequestParam("file") MultipartFile icon, SessionStatus status) {		
		
		if(!icon.isEmpty()) {
			Path resourceDirectory = Paths.get("src//main//resources//static//uploads");
			String rootPath = resourceDirectory.toFile().getAbsolutePath();
			try {
				byte[] bytes = icon.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + icon.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				categoryEntity.setIcon(icon.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
		categoryServices.save(categoryEntity);
		status.setComplete();
		return "redirect:categorias";
	}
	
	@GetMapping(value="/newCategory/{id}")
	public String editCategory(@PathVariable(value="id") Integer id, Model model) {
		CategoryEntity categoryEntity = categoryServices.findOne(id);
		model.addAttribute("category",categoryEntity);
		model.addAttribute("title","Editar Categoria");
		return "nuevaCategoria";
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminarCategoria(@PathVariable(value="id") Integer id) {
		categoryServices.delete(id);
		return "redirect:/categorias";
	}
}
