package com.safetia.nothwind.service;

import java.util.List;

import com.safetia.nothwind.dto.ReplyDTO;

public interface ReplyService {
	public void addReply(ReplyDTO dto) throws Exception;
	public List<ReplyDTO> listReply(int bno) throws Exception;
	public void modifyReply(ReplyDTO dto) throws Exception;
	public void deleteReply(ReplyDTO dto) throws Exception;
}
