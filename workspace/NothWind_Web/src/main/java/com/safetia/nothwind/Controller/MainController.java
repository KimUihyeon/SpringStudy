package com.safetia.nothwind.Controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.safetia.nothwind.daoImpl.MemberDAO;
import com.safetia.nothwind.dto.MemberDTO;
import com.safetia.nothwind.serviceImpl.MemberService;


@Controller
@RequestMapping(value="/main")
public class MainController {

    @Inject
	private MemberDAO dao;

    @Inject
    private MemberService memberService;
	
	@RequestMapping(value="/index")
	public String Home(@ModelAttribute("msg") String msg) throws Exception {

		memberService.GetTest();
		System.out.println("컨트롤러");
		
		return "index";
	}
}
