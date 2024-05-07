package com.hotsix.infra.company;

import java.util.List;

public interface CompanyDao {
	
	public List<CompanyDto> selectList(CompanyVo vo);
	
	public CompanyDto selectOne(CompanyDto dto);
}
