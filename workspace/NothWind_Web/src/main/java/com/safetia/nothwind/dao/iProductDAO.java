package com.safetia.nothwind.dao;

import java.util.List;

import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.util.PageMaker;

public interface iProductDAO {
	
	public List<ProductDTO> getListAll(PageMaker pageMaker);
	public void insert(ProductDTO productDTO);
	public void update(ProductDTO productDTO);
	public ProductDTO detail(int no);
	public void delete (int no);
	
}
