package com.sura.cgapp.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}