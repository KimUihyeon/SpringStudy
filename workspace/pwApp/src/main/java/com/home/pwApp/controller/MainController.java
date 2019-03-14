package com.home.pwApp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.pwApp.HomeController;
import com.home.pwApp.service.AccountService;

@Controller
@RequestMapping("/main")
public class MainController {
	

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Inject
	private AccountService accountService;
	
	@RequestMapping(value= {"/list",""}, method=RequestMethod.GET)
	public String list() {
		accountService.Account(null);
		
		return "list";
	}
	
	/**
	 * 작성자 || 김의현
	 * board Modify Page Controller 
	 */
	@RequestMapping(value="/modfiy", method=RequestMethod.GET)
	public String modify() {
		return "modify";
	}


	/**
	 * 작성자 || 김의현
	 * board Data Modify 
	 */
	@RequestMapping(value="/modfiy", method=RequestMethod.POST)
	public String modify(String a) {
		return null;
	}

	
	/**
	 * 작성자 || 김의현
	 * board Data insert
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(String a) {
		return null;
	}

	/**
	 * 작성자 || 김의현
	 * board detail Page Controller
	 */
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail() {
		return "detail";
	}

	/**
	 * 작성자 || 김의현
	 * board Data Delete
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete() {
		return "";
	}
	
}
