package com.safetia.nothwind.serviceImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.safetia.nothwind.dao.ReplyDAO;
import com.safetia.nothwind.dto.ReplyDTO;
import com.safetia.nothwind.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;

	@Override
	public void addReply(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		dao.create(dto);
	}

	@Override
	public List<ReplyDTO> listReply(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(bno);
	}

	@Override
	public void modifyReply(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
		dao.update(dto);
	}

	@Override
	public void deleteReply(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
		dao.delete(dto);
	}

}
