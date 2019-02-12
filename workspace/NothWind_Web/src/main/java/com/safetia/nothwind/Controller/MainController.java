package com.safetia.nothwind.Controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.safetia.nothwind.dao.MemberDAO;
import com.safetia.nothwind.dto.MemberDTO;
import com.safetia.nothwind.service.MemberService;
import com.safetia.nothwind.study.MemberConfiguration;


@Controller
@RequestMapping(value="/main")
public class MainController {

    @Inject
	private MemberDAO dao;

    @Inject
    private MemberService memberService;
    
    
    @Inject
    @Qualifier("getAdminMember")
    private MemberDTO member;
	
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
		ApplicationContext context = new AnnotationConfigApplicationContext(MemberConfiguration.class);
		MemberDTO member = context.getBean("getAdminMember",MemberDTO.class);
		
		System.out.println(member.getName());
		
		return "home";
	}
}
