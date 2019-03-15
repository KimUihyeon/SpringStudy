package com.home.pwApp.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.home.pwApp.common.FileManager;
import com.home.pwApp.service.FileService;

@Service("fileService")
public class FileServieImpl implements FileService {

	@Resource(name="fileManager")
	private FileManager fileManager;
	
	@Override
	public String update(String uploadPath,String originalName,byte[] fileDate) {
		return fileManager.upload(uploadPath, originalName, fileDate);
	}

}
