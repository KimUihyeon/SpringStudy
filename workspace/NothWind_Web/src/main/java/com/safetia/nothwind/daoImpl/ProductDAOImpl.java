package com.safetia.nothwind.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetia.nothwind.dao.iProductDAO;
import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.util.PageMaker;
import com.safetia.nothwind.util.SearchCriteria;

@Repository
public class ProductDAOImpl implements iProductDAO {

	@Inject
	private SqlSession sqlSession;
	
	
	@Override
	public List<ProductDTO> getListAll(SearchCriteria search,PageMaker pagemaker) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("cri", pagemaker);
		return sqlSession.selectList("productListAll", map);
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
		sqlSession.delete("removeProduct",no);
		
	}


	@Override
	public int listCountCriteria(SearchCriteria search,PageMaker cri) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("cri", cri);
		return sqlSession.selectOne("productCount",map);
	}

}
