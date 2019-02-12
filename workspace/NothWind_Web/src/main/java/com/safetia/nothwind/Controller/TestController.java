package com.safetia.nothwind.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safetia.nothwind.dto.MemberDTO;

@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@RequestMapping("/string")
	public String StringReturn() {
		// String 으로 반환하면 root/String 으로 감
		
		
		
		return "string";
	}
//	
//	
//	@RequestMapping("/void")
//	public void voidReturn() {
//		// Void 로 반환하면 test/Void.jsp로 감
//		
//	}
	
	@RequestMapping("/void")
	public void ModelAttribute(@ModelAttribute("msg") String msg) {
		
	}
	

	@RequestMapping("/jackson")
	public @ResponseBody ArrayList<MemberDTO> test() {
		
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		for(int i=0 ; i<10; i++) {
			String name = "이름" + i ;
			String tel = "전번" + i;
			dtos.add(new MemberDTO(name,tel));
		}

		return dtos;
	}
	@RequestMapping("/jacksonSimple")
	public @ResponseBody MemberDTO test2() {


		MemberDTO dto = new MemberDTO();

		dto.setName("이름");
		dto.setTel("전번");
		return dto;
	}
}
