package com.safetia.nothwind.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect //?
@Component // 문제없음
public class SmapleAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(SmapleAdvice.class);

	

	 @Before("execution(* com.safetia.nothwind.service.iProductService.*(..))")
	 public void startLog() {

		 logger.info("-----------");
		System.out.println("-------------");
		System.out.println("-------------");
	 }
}
