package com.safetia.nothwind.study;

import java.util.HashMap;
import java.util.Map;

public class ProductCreator {
	
	private Map<String,Product> items = new  HashMap<String,Product>();
	
	
	public Map<String, Product> getItems() {
		return items;
	}


	public void setItems(Map<String, Product> items) {
		this.items = items;
	}


	public Product Create(String productName) {
		Product p = items.get(productName);
		if(p!=null) {			
			return p;
		}
		
		throw new IllegalArgumentException("NULL");
	}

}
