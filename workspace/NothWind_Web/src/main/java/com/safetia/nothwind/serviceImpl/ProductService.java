package com.safetia.nothwind.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.safetia.nothwind.daoImpl.ProductDAOImpl;
import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.service.iProductService;

@Service
public class ProductService implements iProductService {
	
	@Inject
	private ProductDAOImpl productDAO; 

	@Override
	public List<ProductDTO> getListAll() {
		// TODO Auto-generated method stub
		ArrayList<ProductDTO> lst =(ArrayList<ProductDTO>) productDAO.getListAll();
		return lst;
	}

}
