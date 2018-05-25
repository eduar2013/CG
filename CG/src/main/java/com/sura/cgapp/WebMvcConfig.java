package com.sura.cgapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sura.cgapp.web.formatter.CategoryEntityFormatter;
import com.sura.cgapp.web.formatter.SubCategoryEntityFormatter;

@Configuration
@ComponentScan("com.sura")
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(new CategoryEntityFormatter());
        formatterRegistry.addFormatter(new SubCategoryEntityFormatter());
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/public/");
    }
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}
	
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class[] {com.sura.cgapp.view.xml.EgresoList.class});
		return marshaller;
	}
}