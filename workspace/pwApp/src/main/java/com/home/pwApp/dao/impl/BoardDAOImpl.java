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

		sqlSession.update("boradModify",dto);
	}

	@Override
	public void delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		
		sqlSession.delete("boradDelete",dto);
	}

	@Override
	public List<BoardDTO> listByUserId(String userId, String type) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("type", type);
		ArrayList<BoardDTO> list =(ArrayList) sqlSession.selectList("boardListByUserId",map); 
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

	@Override
	public BoardDTO selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD
=======

	@Override
	public void deleteAllByDirectoryId(int directoryId) {
		// TODO Auto-generated method stub

		sqlSession.delete("deleteAllByDirectoryId",directoryId);
	}
>>>>>>> d8a72e8d9528a74e4837d14995e5cca0da2bcb14
}
