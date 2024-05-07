package com.hotsix.infra.member;

import java.util.List;

public interface MemberDao {

	public List<MemberDto> selectList(MemberVo vo);
	
	public List<MemberDto> memberList(MemberVo vo);
	
	public MemberDto selectOne(MemberDto dto);
	
	public MemberDto selectLogin(MemberDto dto);
	public int insert(MemberDto dto);
	
	public int update(MemberDto dto);
	
	public int uelete(MemberDto dto);

	public int delete(MemberDto dto);
	
	public int selectOneCount(MemberVo vo);
}
