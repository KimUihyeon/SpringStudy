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
		return sqlSession.selectList("productListAll");
	}


	@Override
	public void insert(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert("productInsert", productDTO);
	}


	@Override
	public void update(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		sqlSession.update("productUpdate",productDTO);
	}


	@Override
	public ProductDTO detail(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectProduct", no);
	}


	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub
		
	}

}
