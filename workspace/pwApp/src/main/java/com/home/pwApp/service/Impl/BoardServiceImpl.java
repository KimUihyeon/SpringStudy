package com.home.pwApp.service.Impl;

import java.util.List;

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
		
	}

	@Override
	public void delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardDTO> listByUserId(String userId) {
		// TODO Auto-generated method stub
		return dao.listByUserId(userId);
	}

	@Override
	public List<BoardDTO> listGroupByDirectory(int directoryId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
