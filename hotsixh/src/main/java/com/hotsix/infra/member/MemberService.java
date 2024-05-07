package com.hotsix.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberDao dao;
	
	public List<MemberDto> selectList(MemberVo vo) {
			
		return dao.selectList(vo);
	}
	
	public List<MemberDto> memberList(MemberVo vo) {
		
		return dao.memberList(vo);
	}
	
	public MemberDto selectOne(MemberDto dto) {
		
		return dao.selectOne(dto);
	}
	
	public int insert(MemberDto dto) {
		
		return dao.insert(dto); 
	}
	
	public int update(MemberDto dto) {
			 dao.update(dto); 
	return 1;	
	}
	
	public int uelete(MemberDto dto) {
		
		return dao.uelete(dto);
	}
	
	public int delete(MemberDto dto) {
		
		return dao.delete(dto);
	}
	
	public int selectOneCount(MemberVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public MemberDto selectLogin(MemberDto dto) {
		return dao.selectLogin(dto);
	}
}
