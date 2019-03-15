package com.home.pwApp.common;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

@Repository("fileManager")
public class FileManager {
	
	public String upload(String uploadPath, String originalName, byte[] fileDate) {
		
		try {
			UUID uid = UUID.randomUUID();
			
			String saveFileName = uid.toString() + "_" + originalName;
			String path = mkDir(uploadPath);

			if(path!=null) {
				File target = new File(path, saveFileName);
				//파일을 저장
				FileCopyUtils.copy(fileDate, target);
				return target.getPath();
			}
			
		}catch(Exception e) {
			System.out.println(e);
			return "err";
		}
		
		return "err";
	}
	
	
	private String CreatePath(String Path) {
		
		
		return "";
	}
	
	private String mkDir(String dirPath) {
		File file = new File(dirPath);
		
		if(!file.exists()) {
			try {
				file.mkdir();
			}
			catch (Exception e) {
				return null;
			}
		}
		return dirPath;
	}
}
