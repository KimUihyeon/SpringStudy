package com.safetia.nothwind.dao;

import java.util.List;

import com.safetia.nothwind.dto.ReplyDTO;

public interface ReplyDAO {
	
	public List<ReplyDTO> list(int bno) throws Exception;
	public void create(ReplyDTO dto) throws Exception;
	public void update(ReplyDTO dto) throws Exception;
	public void delete(ReplyDTO dto) throws Exception;
}
