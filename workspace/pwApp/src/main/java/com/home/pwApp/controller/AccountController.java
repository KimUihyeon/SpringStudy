package com.home.pwApp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.pwApp.dto.MemberDTO;
import com.home.pwApp.service.AccountService;


@Controller
@RequestMapping(value= {"/account",""})
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Inject
	private AccountService accountService; 
	
	@RequestMapping(value={"/index" , "/", "/login"} , method=RequestMethod.GET)
	public String Home() {
		
		return "login";
	}
	
	@RequestMapping(value={"/login"} , method=RequestMethod.POST)
	public String login(MemberDTO member) {
		logger.info(member.getId());
		logger.info(member.getPw());
		
		if(accountService.Account(member)) {
			return "redirect:/main/list";
		}
		else { 
			return "redirect:/login";
		}
	}
	

	@RequestMapping(value={"/logout"} , method=RequestMethod.GET)
	public void logout() {
		logger.info("logout logic");
		
	}
}
