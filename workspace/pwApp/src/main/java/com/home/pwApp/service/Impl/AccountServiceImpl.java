package com.home.pwApp.service.Impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.home.pwApp.dao.MemberDAO;
import com.home.pwApp.dto.MemberDTO;
import com.home.pwApp.service.AccountService;

@Service
public class AccountServiceImpl  implements AccountService{
	
	@Inject
	private MemberDAO memberDAO;
	
	public boolean Account(MemberDTO dto) {
		 
		return  true;
	}
}
