package com.sura.cgapp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subcategorias")
public class SubCategoryEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private double defaultPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CategoryEntity category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDefaultPrice() {
		return defaultPrice;
	}
	public void setDefaultPrice(double defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
	
	public CategoryEntity getCategoria() {
		return category;
	}
	public void setCategoria(CategoryEntity categoria) {
		this.category = categoria;
	}

}
