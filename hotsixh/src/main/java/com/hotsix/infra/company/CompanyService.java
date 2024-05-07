package com.hotsix.infra.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	
	@Autowired
	CompanyDao dao;
	
	public List<CompanyDto> selectList(CompanyVo vo){
		return dao.selectList(vo);
	}
	public CompanyDto selectOne(CompanyDto dto) {
		return dao.selectOne(dto);
	}
}
