package com.safetia.nothwind.Controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.safetia.nothwind.daoImpl.MemberDAO;
import com.safetia.nothwind.dto.MemberDTO;
import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.serviceImpl.MemberService;
import com.safetia.nothwind.serviceImpl.ProductService;
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
    
    @Inject
    private ProductService productService;
	
	public String Home(@ModelAttribute("msg") String msg) throws Exception {
		memberService.GetTest();
		
		return "index";
	}
	
	
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST)
	public void fileUpload(MultipartFile file, Model model) {

		
		System.out.println("111");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
	}

	
	@RequestMapping(value="/index")
	public String Home(Model model) throws Exception {
		memberService.GetTest();
		System.out.println("컨트롤러");
		
//		ArrayList<MemberDTO> test = dao.ListAll();
		
		ArrayList<ProductDTO> products =  (ArrayList<ProductDTO>) productService.getListAll();
//		
//		for (ProductDTO productDTO : products) {
//			productDTO.setTitle(productDTO.getTitle() + "MyBatis Object");
//		}
//		
		
		model.addAttribute("testList",products);
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
		
		String test = testClass.getTest();
		
		model.addAttribute("testObj",test);
		return "home";
	}
}
