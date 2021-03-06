package com.safetia.nothwind.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.safetia.nothwind.daoImpl.ProductDAOImpl;
import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.service.iProductService;
import com.safetia.nothwind.util.PageMaker;
import com.safetia.nothwind.util.SearchCriteria;

@Service
public class ProductService implements iProductService {
	
	@Inject
	private ProductDAOImpl productDAO; 
	

	@Override
	public List<ProductDTO> getListAll(SearchCriteria search,PageMaker pageMaker) {
		// TODO Auto-generated method stub
		
		return productDAO.getListAll(search,pageMaker);
	}

	@Override
	public void insert(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub

		productDAO.insert(dto);
	}

	@Override
	public void update(ProductDTO dto) throws Exception {
		// TODO Auto-generated method stub
		productDAO.update(dto);
	}

	@Override
	public ProductDTO detail(int no) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.detail(no);
	}

	@Override
	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub
		productDAO.delete(no);
		
	}

	@Override
	public int productCount(SearchCriteria search,PageMaker page) throws Exception {
		// TODO Auto-generated method stub
		return productDAO.listCountCriteria(search,page);
	}
	

}
