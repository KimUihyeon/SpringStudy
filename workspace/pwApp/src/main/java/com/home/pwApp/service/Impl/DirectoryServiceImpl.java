package com.home.pwApp.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.home.pwApp.common.FileManager;
import com.home.pwApp.controller.DirectoryController;
import com.home.pwApp.dao.DirectoryDAO;
import com.home.pwApp.dto.DirectoryDTO;
import com.home.pwApp.service.DirectoryService;



/**
 * 작성자 || 김의현
 * Directory Serivce Layer
 */
@Service("directoryService")
public class DirectoryServiceImpl implements DirectoryService {

	private static final Logger logger = LoggerFactory.getLogger(DirectoryServiceImpl.class);

	@Resource(name="fileManager")
	private FileManager fileManager;
	
	@Inject
	private DirectoryDAO directoryDAO;
	

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 추가하기 데이터 추가 로직
	 */
	@Override
	public void insert(Map<String, Object> data) {
		// TODO Auto-generated method stub
		String 		  absPath = (String) data.get("absPath");
		String 		  userId  = (String) data.get("userId");
		MultipartFile file    = (MultipartFile) data.get("file");
		DirectoryDTO  dto     = (DirectoryDTO) data.get("dto");
		

		String uploadPath  = absPath +  "resources/updateFiles/" + userId + "/icon";
		String originalName = file.getOriginalFilename();

		logger.info(uploadPath);
		
		
		try {
			byte[] fileData = file.getBytes();
			String uploadCompletePath = fileManager.upload(uploadPath, originalName, fileData);
			
			if( !"err".equals(uploadCompletePath) ) {

				String savePullPath =  "resources/updateFiles/" + userId + "/icon/"+uploadCompletePath ;
				dto.setIcon(savePullPath);
			}


			logger.info(dto.toString());
			directoryDAO.add(dto);
		}
		catch (Exception e) {
			logger.info(e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public void modify(DirectoryDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		directoryDAO.delete(id);
	}

	@Override
	public ArrayList<DirectoryDTO> listByUserId(String userId) {
		// TODO Auto-generated method stub
		return new ArrayList<DirectoryDTO>(directoryDAO.listByUserId(userId));
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 추가하기 데이터 추가 로직
	 */
	@Override
	public ArrayList<DirectoryDTO> directoriesbyUserId(String userId) {
		// TODO Auto-generated method stub
		return new ArrayList<DirectoryDTO>(directoryDAO.listByUserId(userId));
	}

}
