package com.home.pwApp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.pwApp.dao.DirectoryDAO;
import com.home.pwApp.dto.DirectoryDTO;

@Repository
public class DirectoryDAOImpl implements DirectoryDAO {

	@Inject
	private SqlSession sqlSession;

	/**
	 * 작성자 || 김의현
	 * Directory myBatis Add Logic
	 */
	@Override
	public void add(DirectoryDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("add", dto);
		System.out.println("성공");
	}


	/**
	 * 작성자 || 김의현
	 * Directory myBatis modify Logic
	 */
	@Override
	public void modify(DirectoryDTO dto) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 작성자 || 김의현
	 * Directory myBatis delete Logic
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 작성자 || 김의현
	 * Directory myBatis Select By User ID Logic
	 */
	@Override
	public List<DirectoryDTO> listByUserId(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listByUserId", userId);
	}



}
