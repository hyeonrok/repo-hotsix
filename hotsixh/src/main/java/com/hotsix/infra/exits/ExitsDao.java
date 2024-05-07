package com.hotsix.infra.exits;

import java.util.List;

public interface ExitsDao {

	public List<ExitsDto> selectList(ExitsVo vo);
	
	public int selectOneCount(ExitsVo vo);
	
	public ExitsDto selectOne(ExitsDto dto);
	
	public int insert(ExitsDto dto);
	
	public int accountInsert(ExitsDto dto);
	
	public int update(ExitsDto dto);
	
	public int delete(ExitsDto dto);
	
	public int uelete(ExitsDto dto);
	
	public List<ExitsDto> selectOrder(ExitsVo vo);
}
