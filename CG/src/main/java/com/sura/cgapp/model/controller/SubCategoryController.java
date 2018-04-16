package com.sura.cgapp.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sura.cgapp.model.entity.CategoryEntity;
import com.sura.cgapp.model.entity.SubCategoryEntity;
import com.sura.cgapp.model.services.SubCategoryServices;
import com.sura.cgapp.util.paginator.PageRender;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryServices subCategoryServices;
	
	@GetMapping("/subcategories")
	public String getSubCategories(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = new PageRequest(page,3);
		Page<SubCategoryEntity> subcategoriasPage = subCategoryServices.findAll(pageRequest);
		PageRender<SubCategoryEntity> pageRender = new PageRender<>("/subcategories",subcategoriasPage);
		
		model.addAttribute("title","SubCategorias");
		model.addAttribute("listSubCategories", subcategoriasPage);
		model.addAttribute("page", pageRender);
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
	
	
	@GetMapping(value="/buscarCategoria/{term}", produces= {"application/json"})
	public @ResponseBody List<CategoryEntity> buscarCategoria(@PathVariable(value="term") String term) {
		
		List a = subCategoryServices.findByName(term);
		System.out.println(a);
		
		return a;
	}
	
	
	
}