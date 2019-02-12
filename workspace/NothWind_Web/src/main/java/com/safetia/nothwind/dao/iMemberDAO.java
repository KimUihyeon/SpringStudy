package com.safetia.nothwind.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.safetia.nothwind.dto.MemberDTO;



public interface iMemberDAO {
	
	public ArrayList<MemberDTO> ListAll() throws Exception;

}
