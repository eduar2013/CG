package com.sura.cgapp.view.xml;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.sura.cgapp.model.entity.Egreso;

@Component("egreso/egresoView.xml")
public class EgresosListXmlView extends MarshallingView{
	
	@Autowired
	public EgresosListXmlView(Jaxb2Marshaller marshaller) {
		super(marshaller);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		model.remove("title");
		model.remove("page");
		Page<Egreso> egresosPage = (Page<Egreso> )model.get("egresosList");		
		model.remove("egresosList");
		
		model.put("egresoList", new EgresoList(egresosPage.getContent()));

		super.renderMergedOutputModel(model, request, response);
	}
}