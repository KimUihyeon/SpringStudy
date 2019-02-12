package com.safetia.nothwind.serviceImpl;

import org.springframework.stereotype.Service;

import com.safetia.nothwind.service.iMemberService;

@Service
public class MemberService implements iMemberService  {
	
	public void GetTest() {
		System.out.println("Test");
	}
}
