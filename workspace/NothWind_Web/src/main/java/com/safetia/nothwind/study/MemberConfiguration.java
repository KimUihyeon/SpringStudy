package com.safetia.nothwind.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.safetia.nothwind.dto.MemberDTO;

@Configuration
public class MemberConfiguration {

	@Bean
	@Scope("prototype")
	public MemberDTO getAdminMember() {
		MemberDTO member = new MemberDTO();
		member.setName("관리자");
		return member;
	}
	
	
	@Bean
	public MemberDTO getNomalMember() {
		MemberDTO member = new MemberDTO();
		member.setName("김의현");
		return member;
	}
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer
		propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
