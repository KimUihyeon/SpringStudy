package com.safetia.nothwind.service;

import java.util.List;

import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.util.PageMaker;

public interface iProductService {
	
	public List<ProductDTO> getListAll(PageMaker ßpageMaker) throws Exception;
	public void insert(ProductDTO dto) throws Exception;
	public void update(ProductDTO dto) throws Exception;
	public ProductDTO detail(int no) throws Exception;
	public void delete(int no) throws Exception;
	public int productCount(PageMaker page)throws Exception;
}
