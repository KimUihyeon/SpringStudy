package com.safetia.nothwind.daoImpl;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetia.nothwind.dao.iMemberDAO;
import com.safetia.nothwind.dto.MemberDTO;

@Repository
public class MemberDAO implements iMemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public ArrayList<MemberDTO> ListAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
