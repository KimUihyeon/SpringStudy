package com.safetia.nothwind.daoImpl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetia.nothwind.dao.iProductDAO;
import com.safetia.nothwind.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements iProductDAO {

	@Inject
	private SqlSession sqlSession;
	
	
	@Override
	public List<ProductDTO> getListAll() {
		// TODO Auto-generated method stub
		
		SqlSession sadas = sqlSession; 
		return sqlSession.selectList("productListAll");
	}

}
