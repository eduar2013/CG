package com.sura.cgapp.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sura.cgapp.model.services.SubCategoryServices;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryServices subCategoryServices;
	
	@GetMapping("/subcategories")
	public String getSubCategories(Model model) {
		model.addAttribute("listSubCategories", subCategoryServices.findAll());
		return "subcategories";
	}
}