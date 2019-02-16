package com.safetia.nothwind.Controller;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safetia.nothwind.dto.MemberDTO;
import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.serviceImpl.ProductService;

@Controller
@RequestMapping("/study")
public class StudyController {
	
	@Inject
	private ProductService productService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET )
	public String list(Model model, int pageNo) {
		model.addAttribute("products",productService.getListAll());
		model.addAttribute("listPageNo", pageNo);
		System.out.println(pageNo);
		return "./study/list";
	}
	
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String detail(Model model,int pageNo,int no) throws Exception {
		
		System.out.println(no);
		
		ProductDTO product = productService.detail(no);
		model.addAttribute("product", product);
		model.addAttribute("listPageNo", pageNo);
		
		return "./study/detail";
	}
	
	 public String filter() {
		 return "./study/filter";
	 }
	 
	 
	 /**
	  * @ 작성자 김의현
	  * @ 일시 19.02.15
	  * @ description Modify Page Call
	  */
	 @RequestMapping(value="/modify", method=RequestMethod.GET)
	 public String modify(Model model, int pageNo , int no) throws Exception {

		 ProductDTO product = productService.detail(no);
		 model.addAttribute("product", product);
		 model.addAttribute("listPageNo  ", pageNo);
		 return "./study/modify";
	 }
	 
	 /**
	  * @ 작성자 김의현
	  * @ 일시 19.02.15
	  * @ description Modify DB Update 
	  */
	 @RequestMapping(value="/modify" , method=RequestMethod.POST)
	 public String modify(ProductDTO product, MemberDTO member){
		 try {
			 productService.update(product);	 
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 return "redirect:../error";
		}
		 
		 return "redirect:../study/list?pageNo=1";
	 }
}
