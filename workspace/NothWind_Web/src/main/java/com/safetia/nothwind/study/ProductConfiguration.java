package com.safetia.nothwind.study;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
	
	
	@Bean
	public ProductCreator ProductCreator() {
		ProductCreator products = new ProductCreator();
		Map<String,Product> items = new HashMap(); 

		items.put("베터리", new Battery());
		items.put("사과", new Apple());
		products.setItems(items);
		
		return products;
	}
	
	
	@Bean
	public Product Battery() {
		return ProductCreator().Create("베터리");
	}
	
	@Bean
	public Product Apple() {
		return ProductCreator().Create("사과");
	}
}
