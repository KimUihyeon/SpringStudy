package com.home.pwApp.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.pwApp.dao.MemberDAO;
import com.home.pwApp.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public MemberDTO getMemberById(String id) {
		// TODO Auto-generated method stub
		
 		MemberDTO dto = sqlSession.selectOne("AllList");
		System.out.println(dto.getId());
		return dto;
	}
	
}
