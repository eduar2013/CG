package com.sura.cgapp.util.paginator;

public class PageItem {
	
	private int numberPage;
	private boolean blActual;
	
	public PageItem(int numberPage, boolean blActual) {
		this.numberPage = numberPage;
		this.blActual = blActual;
	}
	
	public int getNumberPage() {
		return numberPage;
	}
	
	public boolean isBlActual() {
		return blActual;
	}
	
}
