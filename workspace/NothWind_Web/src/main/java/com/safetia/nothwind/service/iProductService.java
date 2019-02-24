package com.safetia.nothwind.service;

import java.util.List;

import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.util.PageMaker;
import com.safetia.nothwind.util.SearchCriteria;

public interface iProductService {
	
	public List<ProductDTO> getListAll(SearchCriteria search,PageMaker ßpageMaker) throws Exception;
	public void insert(ProductDTO dto) throws Exception;
	public void update(ProductDTO dto) throws Exception;
	public ProductDTO detail(int no) throws Exception;
	public void delete(int no) throws Exception;
	public int productCount(SearchCriteria search,PageMaker page)throws Exception;
}
