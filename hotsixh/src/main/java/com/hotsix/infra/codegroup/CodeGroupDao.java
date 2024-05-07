package com.hotsix.infra.codegroup;

import java.util.List;




public interface CodeGroupDao {
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	
	public CodeGroupDto selectOne(CodeGroupDto dto);
	
	public int insert(CodeGroupDto dto);
	
	public int update(CodeGroupDto dto);
	
	public int uelete(CodeGroupDto dto);
	
	public int delete(CodeGroupDto dto);
	
	public int selectOneCount(CodeGroupVo vo);
	
	public List<CodeGroupDto> selectListWithoutPaging();
}
