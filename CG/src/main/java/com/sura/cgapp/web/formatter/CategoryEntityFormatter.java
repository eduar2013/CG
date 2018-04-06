package com.sura.cgapp.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.sura.cgapp.model.entity.CategoryEntity;

public class CategoryEntityFormatter implements Formatter<CategoryEntity>{

	@Override
	public String print(CategoryEntity categoryEntity, Locale locale) {
		return String.valueOf(categoryEntity.getId());
	}

	@Override
	public CategoryEntity parse(String id, Locale locale) throws ParseException {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(Integer.parseInt(id));
		return categoryEntity;
	}
}
