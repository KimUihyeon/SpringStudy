package com.home.pwApp.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.home.pwApp.dto.DirectoryDTO;
import com.home.pwApp.service.FileService;

@Controller
@RequestMapping("/directory")
public class DirectoryController {

	private static final Logger logger = LoggerFactory.getLogger(DirectoryController.class);
	
	@Inject
	@Qualifier("fileService")
	private FileService fileService;
	
	
	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * directory로 묶어보기 페이지 컨트롤러 
	 */
	@RequestMapping(value= {"/index","list",""})
	public String List() {
		
		return "directory/list";
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 수정하기 페이지 컨트롤 
	 */
	@RequestMapping(value = "/modify", method= RequestMethod.GET)
	public String modify() {
		
		return "directory/modify";
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 추가하기 페이지 컨트롤 
	 */
	@RequestMapping(value = "/insert", method= RequestMethod.GET)
	public String insert() {
		
		return "directory/modify";
	}
	
	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 추가하기 데이터 추가 로직
	 */
	@RequestMapping(value = "/insert", method= RequestMethod.POST)
	public String insert(MultipartHttpServletRequest request,
							DirectoryDTO dto,MultipartFile file) {
		
		logger.info(dto.toString());
		String loginId = "dkrnl1318";
		String uploadPath = request.getSession().getServletContext().getRealPath("/") 
							+ "resources/updateFiles/" +loginId + "/icon";
		
		String originalName = file.getOriginalFilename();
		byte[] fileData;
		
		String uploadCompletePath = "";
		try {
			fileData = file.getBytes();
			uploadCompletePath = fileService.update(uploadPath, originalName, fileData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "directory/modify";
	}


	/**
	 * 작성자 | 김의현
	 * 작업일시|| 19.03.15
	 * 자세히 보기 페이지 컨트롤 
	 */
	@RequestMapping(value = "/detail", method= RequestMethod.GET)
	public String detail() {
		
		return "directory/modify";
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 수정하기 Form Data 처리 로직 
	 */
	@RequestMapping(value = "/modify" , method= RequestMethod.POST)
	public void modify(String data) {
		
	}
	
	
}
