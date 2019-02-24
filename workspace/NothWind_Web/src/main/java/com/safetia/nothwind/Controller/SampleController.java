package com.safetia.nothwind.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetia.nothwind.dto.MemberDTO;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping("/member")
	public MemberDTO member() {
		MemberDTO dto = new MemberDTO();
		dto.setName("이름");
		dto.setTel("전화번호");
		return dto;
	}
}
