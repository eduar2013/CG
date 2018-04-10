package com.sura.cgapp.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sura.cgapp.model.entity.SubCategoryEntity;
import com.sura.cgapp.model.services.SubCategoryServices;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryServices subCategoryServices;
	
	@GetMapping("/subcategories")
	public String getSubCategories(Model model) {
		model.addAttribute("title","SubCategorias");
		model.addAttribute("listSubCategories", subCategoryServices.findAll());
		return "subcategories";
	}
	
	@GetMapping("/newSubCategory")
	public String newSubCategory(Model model) {
		model.addAttribute("subcategory",new SubCategoryEntity());
		model.addAttribute("listCategories",subCategoryServices.getCategory());
		model.addAttribute("title","Nueva SubCategoria");
		return "nuevaSubCategoria";
	}
	
	@PostMapping("/newSubCategory")
	public String createSubCategory(SubCategoryEntity subCategoryEntity, Model model) {		
		subCategoryServices.save(subCategoryEntity);
		return "redirect:subcategories";
	}
	
	@GetMapping(value="/deleteSubCategory/{id}")
	public String deleteSubCategory(@PathVariable(value="id") Integer id, RedirectAttributes flash) {
		subCategoryServices.delete(id);
		flash.addFlashAttribute("success","Subcategoria eliminada correctamente");
		return "redirect:/subcategories";
	}
}