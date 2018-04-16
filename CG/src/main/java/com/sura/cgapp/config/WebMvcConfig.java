package com.sura.cgapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sura.cgapp.web.formatter.CategoryEntityFormatter;

@Configuration
@ComponentScan("com.sura")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(new CategoryEntityFormatter());
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/public/");
    }
	
	
}
