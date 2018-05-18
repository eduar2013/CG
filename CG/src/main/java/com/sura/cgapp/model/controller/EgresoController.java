package com.sura.cgapp.model.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sura.cgapp.model.entity.Egreso;
import com.sura.cgapp.model.services.EgresoServices;
import com.sura.cgapp.model.services.SubCategoryServices;
import com.sura.cgapp.util.paginator.PageRender;

@Controller
@RequestMapping({"/","/egreso"})
public class EgresoController {
	
	@Autowired
	EgresoServices egresoServices;
	
	@Autowired
	SubCategoryServices subcategoryServices;
	
	
	Log logger = LogFactory.getLog(EgresoController.class);
	
	@GetMapping({"/","/listarEgresos"})
	public String listarEgresos(@RequestParam(name="page", defaultValue="0") int page, Model model,HttpServletRequest request) {
		
		
		Pageable pageRequest = new PageRequest(page,3);
		Page<Egreso> egresosPage = egresoServices.findAll(pageRequest);
		PageRender<Egreso> pageRender = new PageRender<>("/listarEgresos",egresosPage);

		model.addAttribute("egreso", new Egreso());
		model.addAttribute("egresosList",egresosPage);
		model.addAttribute("title", "Gastos");
		model.addAttribute("page", pageRender);
		model.addAttribute("listSubCategorias", subcategoryServices.getSubCategories());
		
		
		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request,"ROLE_");
		if(securityContext.isUserInRole("ADMIN")) {
			logger.info("Usuario tiene el Rol 'ROLE_ADMIN'");
		}else {
			logger.info("Usuario NOO tiene el Rol 'ROLE_ADMIN'");
		}
		
		
		if(request.isUserInRole("ROLE_ADMIN")) {
			logger.info("Usuario tiene el Rol 'ROLE_ADMIN' validando con request");
		}else {
			logger.info("Usuario NOOO tiene el Rol 'ROLE_ADMIN' validando con request");
		}
		return "egreso/egresoView";
	}
	
	@PostMapping("/grabarEgreso")
	public String grabarEgreso(Egreso egreso,Model model) {
		egresoServices.grabarEgreso(egreso);
		return "redirect:/egreso/listarEgresos";
	}
	
	@GetMapping(value="/eliminarGasto/{id}")
	public String eliminarGasto(@PathVariable(value="id") long id, Model model) {
		egresoServices.deleteEgreso(id);
		model.addAttribute("success","Egreso eliminado correctamente");
		return "redirect:/egreso/listarEgresos";
	}

}
