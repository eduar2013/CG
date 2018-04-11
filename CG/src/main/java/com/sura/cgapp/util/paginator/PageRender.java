package com.sura.cgapp.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;
	private Page<T> page;
	
	private int totalPages;
	private int numElementsByPage;
	private int paginaActual;
	
	private List<PageItem> pageItems;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pageItems = new ArrayList<>();
		
		this.numElementsByPage = page.getSize();
		this.totalPages = page.getTotalPages();
		this.paginaActual = page.getNumber() + 1;
		
		int desde  = 0;
		int hasta = totalPages;
		
		for(int i = desde;i < hasta; i++) {
			pageItems.add(new PageItem(desde+1,paginaActual == desde+1));
		}
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPageItems() {
		return pageItems;
	}
	
	public boolean isFirs() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHashNext() {
		return page.hasNext();
	}
	
	public boolean isHashPrevius() {
		return page.hasPrevious();
	}
	
}
