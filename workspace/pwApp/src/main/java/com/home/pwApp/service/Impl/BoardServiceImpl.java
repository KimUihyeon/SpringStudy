package com.home.pwApp.service.Impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.home.pwApp.dao.BoardDAO;
import com.home.pwApp.dto.BoardDTO;
import com.home.pwApp.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Override
	public void add(BoardDTO dto) {
		// TODO Auto-generated method stub
		dao.add(dto);
	}

	@Override
	public void modify(BoardDTO dto) {
		// TODO Auto-generated method stub
		dao.modify(dto);		
	}

	@Override
	public void delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	public List<BoardDTO> listByUserId(String userId, String type) {
		// TODO Auto-generated method stub
		return dao.listByUserId(userId,type);
	}

	@Override
	public List<BoardDTO> listGroupByDirectory(int directoryId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object>  selectBoard(String userId, int boardId) {
		// TODO Auto-generated method stub
		return  dao.selectBoard(userId,boardId);
	}

	@Override
	public BoardDTO selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllByDirectoryId(int directoryId) {
		// TODO Auto-generated method stub
		dao.deleteAllByDirectoryId(directoryId);
	}

}
