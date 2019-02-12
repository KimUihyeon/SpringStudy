package com.safetia.nothwind.Controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.safetia.nothwind.dao.MemberDAO;
import com.safetia.nothwind.dto.MemberDTO;
import com.safetia.nothwind.service.MemberService;


@Controller
@RequestMapping(value="/main")
public class MainController {

    @Inject
	private MemberDAO dao;

    @Inject
    private MemberService memberService;
	
	@RequestMapping(value="/index")
	public String Home(Model model) throws Exception {

		
		memberService.GetTest();
		System.out.println("컨트롤러");
		
		ArrayList<MemberDTO> test = dao.ListAll();
		
		
		model.addAttribute("testList",test);
		return "home";
	}
	
	
	@RequestMapping(value="test")
	public String Test() {
		
		System.out.println("tset Controller");
		
		return "home";
	}
}
