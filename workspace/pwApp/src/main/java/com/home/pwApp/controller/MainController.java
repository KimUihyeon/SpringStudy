package com.home.pwApp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.pwApp.dto.BoardDTO;
import com.home.pwApp.service.AccountService;
import com.home.pwApp.service.BoardService;
import com.home.pwApp.service.DirectoryService;

@Controller
@RequestMapping("/main")
public class MainController {
	

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Inject
	private AccountService accountService;

	@Inject
	private DirectoryService directoryService;
	
	@Inject
	private BoardService boardService;

	@Resource(name="devUserId")
	private String userId;
	
	
	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 게시판 리스트로 보기 페이지 컨트롤러 
	 */
	@RequestMapping(value= {"/list",""}, method=RequestMethod.GET)
	public String list(Model model) {
		List<BoardDTO> dtd= boardService.listByUserId(userId);
		
		for (BoardDTO boardDTO : dtd) {
			System.out.println(boardDTO.getDirectoryDTO().getTitle());
		}
		model.addAttribute("boards", boardService.listByUserId(userId));
		return "/board/list";
	}
	
	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 게시판 수정하기 페이지 컨트롤
	 */
	@RequestMapping(value="/modfiy", method=RequestMethod.GET)
	public String modify(Model model) {

		model.addAttribute("directories",directoryService.directoriesbyUserId(userId));
		return "/board/modify";
	}


	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 게시판 수정하기 데이터 처리 로직 
	 */
	@RequestMapping(value="/modfiy", method=RequestMethod.POST)
	public String modify(String a) {
		
		
		return null;
	}


	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 게시판 데이터 페이지 컨트롤러 
	 */
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		

		model.addAttribute("directories",directoryService.directoriesbyUserId(userId));
		return "/board/modify";
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 게시판 데이터 추가하기 처리 로직 
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(BoardDTO dto) {
		
		logger.info(dto.toString());
		boardService.add(dto);
		return null;
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 게시판 자세히보기 페이지 컨트롤러 
	 */
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail() {
		return "/board/detail";
	}

	/**
	 * 작성자 || 김의현
	 * 작업일시|| 19.03.15
	 * 게시판 삭제하기 처리 로직 
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete() {
		return "";
	}
	
}
