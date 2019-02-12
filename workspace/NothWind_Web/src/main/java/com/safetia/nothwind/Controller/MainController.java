package com.safetia.nothwind.Controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
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
@RequestMapping(value="/main")
public class MainController {

    @Inject
	private MemberDAO dao;

    @Inject
    private MemberService memberService;
    
    @Inject
    @Qualifier("getAdminMember")
    private MemberDTO member;
    
    @Inject
    private TestClsee testClass;
	
	@RequestMapping(value="/index")
	
	public String Home(@ModelAttribute("msg") String msg) throws Exception {

		memberService.GetTest();
		System.out.println("컨트롤러");
		
		return "index";
	}
	
	public String Home(Model model) throws Exception {
		memberService.GetTest();
		System.out.println("컨트롤러");
		
		ArrayList<MemberDTO> test = dao.ListAll();
		
		model.addAttribute("testList",test);
		return "home";
	}
	
	
	@RequestMapping(value="test")
	public String Test(Model model) {

		/// 마스터 병합 이후 Commit
		
		System.out.println(testClass.getTest());
		ApplicationContext context = new AnnotationConfigApplicationContext(MemberConfiguration.class);
		
		MemberDTO member = context.getBean("getAdminMember",MemberDTO.class); 
		member.setName("관리자 변경");
		
		System.out.println(member.getName());
		
		MemberDTO member2 = context.getBean("getAdminMember",MemberDTO.class); // 싱글톤으로 관리됨
		System.out.println(member2.getName());
		
		Resource test = testClass.getTxtFileContext();
		
		model.addAttribute("testObj",test);
		return "home";
	}
}
