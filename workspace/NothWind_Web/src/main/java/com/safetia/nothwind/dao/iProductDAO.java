package com.safetia.nothwind.dao;

import java.util.List;

import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.util.PageMaker;
import com.safetia.nothwind.util.SearchCriteria;

public interface iProductDAO {
	
	public List<ProductDTO> getListAll(SearchCriteria search,PageMaker pageMaker);
	public void insert(ProductDTO productDTO);
	public void update(ProductDTO productDTO);
	public ProductDTO detail(int no);
	public void delete (int no);
	public int listCountCriteria(SearchCriteria search,PageMaker cri);
	
}
