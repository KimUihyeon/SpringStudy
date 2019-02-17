package com.safetia.nothwind.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionController {
	
	
	@ExceptionHandler(Exception.class)
	private String errorView(Exception e,Model model) {
		model.addAttribute("error", e);
		return "./common/error";
	}
}
