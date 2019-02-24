package com.safetia.nothwind.daoImpl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.safetia.nothwind.dao.ReplyDAO;
import com.safetia.nothwind.dto.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession sqlsession;

	@Override
	public List<ReplyDTO> list(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList("replyList",bno);
	}

	@Override
	public void create(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.insert("replyInsert",dto);
	}

	@Override
	public void update(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.insert("replyUpdate",dto);
	}

	@Override
	public void delete(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.insert("replyDelete",dto);
	}

}
