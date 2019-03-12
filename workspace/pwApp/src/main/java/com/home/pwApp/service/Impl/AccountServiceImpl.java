package com.home.pwApp.service.Impl;

import org.springframework.stereotype.Service;

import com.home.pwApp.dto.MemberDTO;
import com.home.pwApp.service.AccountService;

@Service
public class AccountServiceImpl  implements AccountService{
	
	
	
	public boolean Account(MemberDTO dto) {
		MemberDTO dbDTO = new MemberDTO();
		if(dbDTO ==null) {
			return false;
		}
		else {
			return  true;
		} 
	}
}
