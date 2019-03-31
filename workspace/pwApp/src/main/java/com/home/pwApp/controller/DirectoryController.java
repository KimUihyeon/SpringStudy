package com.home.pwApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.home.pwApp.dto.DirectoryDTO;
import com.home.pwApp.service.BoardService;
import com.home.pwApp.service.DirectoryService;
import com.home.pwApp.service.FileService;

@Controller
@RequestMapping("/directory")
public class DirectoryController {

	private static final Logger logger = LoggerFactory.getLogger(DirectoryController.class);
	
	@Inject
	@Qualifier("directoryService")
	private DirectoryService directoryService;
	
	@Inject
	private BoardService boardService;
	
	@Resource(name="devUserId")
	private String userId;
	
	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * directory로 묶어보기 페이지 컨트롤러 
	 */
	@RequestMapping(value= {"/index","list",""})
	public String List(Model model) {
		
		ArrayList<DirectoryDTO> dtos = directoryService.listByUserId(userId);
		model.addAttribute("directories", dtos);
		return "/directory/list";
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 수정하기 페이지 컨트롤 
	 */
	@RequestMapping(value = "/modify", method= RequestMethod.GET)
	public String modify() {
		
		return "/directory/modify";
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 추가하기 페이지 컨트롤 
	 */
	@RequestMapping(value = "/insert", method= RequestMethod.GET)
	public String insert() {
		
		return "/directory/insert";
	}
	
	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 추가하기 데이터 추가 로직
	 */
	@RequestMapping(value = "/insert", method= RequestMethod.POST)
	public String insert(MultipartHttpServletRequest request,
							DirectoryDTO dto,MultipartFile file) {
		
		dto.setUserId(userId);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("absPath", request.getSession().getServletContext().getRealPath("/").toString());
		dataMap.put("userId", userId);
		dataMap.put("file", file);
		dataMap.put("dto", dto);
		
		
		try {
			directoryService.insert(dataMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			return "redirect:/directory/modify";
		}
		
		return "redirect:/directory/list";
	}


	/**
	 * 작성자 | 김의현
	 * 작업일시|| 19.03.15
	 * 자세히 보기 페이지 컨트롤 
	 */
	@RequestMapping(value = "/detail", method= RequestMethod.GET)
	public String detail() {
		
		return "/directory/modify";
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 수정하기 Form Data 처리 로직
	 */
	@RequestMapping(value = "/modify" , method= RequestMethod.POST)
	public String modify(String data) {

		return "redirect:/directory/list";
	}
	

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.23
	 * 삭제하기 directorty Delete 처리 로직
	 */
	@RequestMapping(value="/delete" , method= RequestMethod.POST)
	public String delete(DirectoryDTO dto) {
		boardService.deleteAllByDirectoryId(dto.getId());
		directoryService.delete(dto.getId());
		return "redirect:/directory/list";
	}
	
}
