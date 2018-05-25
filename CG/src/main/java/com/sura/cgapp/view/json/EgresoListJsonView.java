package com.sura.cgapp.view.json;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component("egreso/egresoView")
public class EgresoListJsonView extends MappingJackson2JsonView{

	@Override
	protected Object filterModel(Map<String, Object> model) {
		model.remove("title");
		model.remove("page");
		return super.filterModel(model);
	}
	
	
}