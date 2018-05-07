package com.sura.cgapp.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import com.sura.cgapp.model.entity.SubCategoryEntity;

public class SubCategoryEntityFormatter implements Formatter<SubCategoryEntity> {

	@Override
	public String print(SubCategoryEntity subcategory, Locale locale) {
		return String.valueOf(subcategory.getId());
	}

	@Override
	public SubCategoryEntity parse(String id, Locale locale) throws ParseException {
		SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
		subCategoryEntity.setId(Integer.parseInt(id));
		return subCategoryEntity;
	}
}