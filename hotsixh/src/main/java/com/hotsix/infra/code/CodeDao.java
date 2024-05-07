package com.hotsix.infra.code;

import java.util.List;


public interface CodeDao {
	
	public List<CodeDto> selectList(CodeVo vo);
	
	public CodeDto selectOne(CodeDto dto);
	
	public int insert(CodeDto dto);
	
	public int update(CodeDto dto); 
	
	public int uelete(CodeDto dto);
	
	public int delete(CodeDto dto);

	public List<CodeDto> selectListCachedCodeArrayList();
	
	public int selectOneCount(CodeVo vo);
}
