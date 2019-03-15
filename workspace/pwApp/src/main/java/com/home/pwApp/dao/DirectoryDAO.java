package com.home.pwApp.dao;

import java.util.ArrayList;
import java.util.List;

import com.home.pwApp.dto.DirectoryDTO;

public interface DirectoryDAO {
	
	public void add(DirectoryDTO dto);
	public void modify(DirectoryDTO dto);
	public void delete(int id);
	public List<DirectoryDTO> listByUserId(String userId);
}
