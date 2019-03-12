package com.home.pwApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/group")
public class GroupController {
	
	@RequestMapping(value= {"/index",""})
	public String groupList() {
		
		return "groupList";
	}

	@RequestMapping(value = "modify", method= RequestMethod.GET)
	public String groupModify() {
		
		return "groupModify";
	}

	@RequestMapping(value = "detail", method= RequestMethod.GET)
	public String groupDetail() {
		
		return "groupModify";
	}

	@RequestMapping(value = "modify" , method= RequestMethod.POST)
	public void GroupModify() {
		
	}
	
	
}
