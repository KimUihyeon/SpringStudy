package com.home.pwApp.dao;

import java.util.List;

import com.home.pwApp.dto.BoardDTO;

public interface BoardDAO {

	public void add(BoardDTO dto);
	public void modify(BoardDTO dto);
	public void delete(BoardDTO dto);
	public List<BoardDTO> listByUserId(String userId);
	public List<BoardDTO> listGroupByDirectory(int directoryId, String userId);
	
}
