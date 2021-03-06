package com.safetia.nothwind.Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.safetia.nothwind.daoImpl.MemberDAO;
import com.safetia.nothwind.dto.MemberDTO;
import com.safetia.nothwind.serviceImpl.MemberService;
import com.safetia.nothwind.study.MemberConfiguration;
import com.safetia.nothwind.study.TestClsee;




@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@RequestMapping("/string")
	public String StringReturn() {
		// String 으로 반환하면 root/String 으로 감
		
		return "string";
	}
	
//	@RequestMapping("/void")
//	public void voidReturn() {
//		// Void 로 반환하면 test/Void.jsp로 감
//	}
	
	@RequestMapping("/void")
	public void ModelAttribute(@ModelAttribute("msg") String msg) {
	}
	
	
	
	@RequestMapping(value="/Account" )
	public String Login(RedirectAttributes attr, String pw){
		
		String redirectPage = "";
		if(pw.equals("123")) {
			redirectPage="redirect:../main/index";
			attr.addAttribute("msg", "s1");
		}
		else {
			redirectPage="redirect:../main/index";
			attr.addAttribute("msg", "e1");
		}
		return redirectPage;
	}
	
	

	@RequestMapping(value="/jackson")
	public @ResponseBody MemberDTO test() {
		MemberDTO dto0 = new MemberDTO();
		MemberDTO dto1 = new MemberDTO();
		MemberDTO dto2 = new MemberDTO();
		
		dto0.setMember(dto1);
		dto1.setMember(dto0);
		
		
//		
//		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
//		
//		for(int i=0 ; i<10; i++) {
//			String name = "이름" + i ;
//			String tel = "전번" + i;
//			dtos.add(new MemberDTO(name,tel));
//		}

		return dto0;
	}
	@RequestMapping("/jacksonSimple")
	public @ResponseBody MemberDTO test2() {


		MemberDTO dto = new MemberDTO();

		dto.setName("이름");
		dto.setTel("전번");
		return dto;
	}
}
