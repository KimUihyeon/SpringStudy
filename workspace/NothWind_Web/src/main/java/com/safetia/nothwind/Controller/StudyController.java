package com.safetia.nothwind.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safetia.nothwind.dto.MemberDTO;
import com.safetia.nothwind.dto.ProductDTO;
import com.safetia.nothwind.serviceImpl.ProductService;
import com.safetia.nothwind.util.PageMaker;

@Controller
@RequestMapping("/study")
public class StudyController {
	
	@Inject
	private ProductService productService;
	
	@Inject // Paging process Logic
	private PageMaker pageMaker;
	
	/**
	 * @ 작성자 김의현
	 * @ 일시 19.02.17
	 * @ description product List Page Call
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET )
	public String list(Model model,@ModelAttribute("pageNo") int pageNo) throws Exception {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(pageNo);
		
		List<ProductDTO> products  = productService.getListAll(pageMaker);
		pageMaker.setTotalCount(productService.productCount(pageMaker));
		
		
		model.addAttribute("products", products);
		model.addAttribute("paging", pageMaker);
		
		
		System.out.println(pageNo);
		return "./study/list";
	}
	
	/**
	 * @ 작성자 김의현
	 * @ 일시 19.02.17
	 * @ description | product Detail View
	 */
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String detail(Model model,@ModelAttribute("pageNo") int pageNo,int no) throws Exception {
		ProductDTO product = productService.detail(no);
		model.addAttribute("product", product);
		
		return "./study/detail";
	}
	
	 
	 /**
	  * @ 작성자 김의현
	  * @ 일시 19.02.15
	  * @ description Modify Page Call
	  */
	 @RequestMapping(value="/modify", method=RequestMethod.GET)
	 public String modify(Model model,@ModelAttribute("pageNo") int pageNo , int no) throws Exception {

		 ProductDTO product = productService.detail(no);
		 model.addAttribute("product", product);
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
			 return "redirect:../commone/error";
		}
		 
		 return "redirect:../study/list?pageNo=1";
	 }
	 
	 
	 
	 /** 
	  * @ 작성자 김의현
	  * @ 일시 19.02.17
	  * @ description Call 등록 페이지.
	  */
	 @RequestMapping(value="/register", method=RequestMethod.GET)
	 public String registor(@ModelAttribute("pageNo")int pageNo) {	 
		 return "./study/register";
	 }
	 
	 /**
	  * @ 작성자 김의현
	  * @ 일시 19.02.17
	  * @ description Product insert
	  */
	 @RequestMapping(value="/register", method=RequestMethod.POST )
	 public String registor(ProductDTO productDTO) {
		try {
			productService.insert(productDTO);
		}
		catch(Exception e) {
			return "redirect:../common/error";
		}
		return "redirect:../study/list?pageNo=1";
	 }
	 
	 
	 /** 
	 * @ 작성자 김의현
	  * @ 일시 19.02.17
	  * @ description | product delete process
	  */
	 @RequestMapping(value="/delete", method= RequestMethod.GET)
	 public String delete(int pageNo,ProductDTO productdto) throws NumberFormatException, Exception {

		 productService.delete(Integer.parseInt(productdto.getNo()));
		 
		 return "redirect:../study/list?pageNo="+pageNo;
	 }
	 
}
