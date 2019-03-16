package com.home.pwApp.service;

import java.util.ArrayList;
import java.util.Map;

import com.home.pwApp.dto.DirectoryDTO;

public interface DirectoryService {
	
	public void insert(Map<String,Object> data);
	public void modify(DirectoryDTO dto);
	public void delete(int id);
	public ArrayList<DirectoryDTO> listByUserId(String userId);
	public ArrayList<DirectoryDTO> directoriesbyUserId(String userId);
}
