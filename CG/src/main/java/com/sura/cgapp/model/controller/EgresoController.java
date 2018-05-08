package com.sura.cgapp.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sura.cgapp.model.entity.Egreso;
import com.sura.cgapp.model.services.EgresoServices;
import com.sura.cgapp.model.services.SubCategoryServices;

@Controller
@RequestMapping({"/","/egreso"})
public class EgresoController {
	
	@Autowired
	EgresoServices egresoServices;
	
	@Autowired
	SubCategoryServices subcategoryServices;
	
	@GetMapping({"/","/listarEgresos"})
	public String listarEgresos(Model model) {
		model.addAttribute("egreso", new Egreso());
		model.addAttribute("egresosList",egresoServices.findAll());
		model.addAttribute("title", "Gastos");
		model.addAttribute("listSubCategorias", subcategoryServices.getSubCategories());
		return "egreso/egresoView";
	}
	
	@PostMapping("/grabarEgreso")
	public String grabarEgreso(Egreso egreso,Model model) {
		egresoServices.grabarEgreso(egreso);
		return "redirect:/egreso/listarEgresos";
	}

}
