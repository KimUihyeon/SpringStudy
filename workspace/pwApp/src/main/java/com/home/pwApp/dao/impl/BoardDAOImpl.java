package com.home.pwApp.dao.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.home.pwApp.dao.BoardDAO;
import com.home.pwApp.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void add(BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("boradAdd",dto);
	}

	@Override
	public void modify(BoardDTO dto) {
		// TODO Auto-generated method stub

		sqlSession.update("modify",dto);
	}

	@Override
	public void delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		
		sqlSession.delete("delete",dto);
	}

	@Override
	public List<BoardDTO> listByUserId(String userId) {
		// TODO Auto-generated method stub
		ArrayList<BoardDTO> list =(ArrayList) sqlSession.selectList("boardListByUserId",userId); 
		return list;
	}

	@Override
	public List<BoardDTO> listGroupByDirectory(int directoryId, String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("directoryId", directoryId);
		map.put("userId", userId);
		return sqlSession.selectList("listGroupByDirectory",map);
	}

	@Override
	public Map<String, Object>  selectBoard(String userId, int boardId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("boardId", boardId);
		return  sqlSession.selectOne("boardSelectOne",map);
	}
}
