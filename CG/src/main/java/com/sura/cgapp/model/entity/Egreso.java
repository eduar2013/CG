package com.sura.cgapp.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "egresos")
public class Egreso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	@Temporal(TemporalType.DATE)
	private Date fechaEgreso;

	@OneToOne
	@JsonIgnore
	private SubCategoryEntity subcategoria;
	
	private int cantidad;
	private double valor;	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	
	@XmlTransient
	public SubCategoryEntity getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(SubCategoryEntity subcategoria) {
		this.subcategoria = subcategoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
