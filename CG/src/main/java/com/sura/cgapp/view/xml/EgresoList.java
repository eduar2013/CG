package com.sura.cgapp.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sura.cgapp.model.entity.Egreso;

@XmlRootElement(name="egresos")
public class EgresoList {
	
	@XmlElement(name="egreso")
	public List<Egreso> egresos;
	
	public EgresoList() {		
	}
	
	public EgresoList(List<Egreso> egresos) {
		this.egresos = egresos;
	}

	public List<Egreso> getEgresos() {
		return egresos;
	}
}	