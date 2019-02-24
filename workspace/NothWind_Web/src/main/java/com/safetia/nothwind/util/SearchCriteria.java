package com.safetia.nothwind.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SearchCriteria {
	
	private String keyword;
	private String productNo;
	private String minPrice;
	private String maxPrice;

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
