package com.home.pwApp.dao.impl;

import java.util.HashMap;

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
	public MemberDTO getMemberById(String id,String pw) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);
		return sqlSession.selectOne("memberSelectOne", map);
	}
	
}
