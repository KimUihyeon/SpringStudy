package com.home.pwApp;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.home.pwApp.dto.BoardDTO;

public class TestClass {

	@Inject
	private SqlSession sqlSession;
	
	@Resource(name="devUserId")
	private String loginID;
	
	
	public void test() {
		//String userId = "admin";
		List<BoardDTO> list = sqlSession.selectList("boardListByUserId",loginID);
		
	}
}
