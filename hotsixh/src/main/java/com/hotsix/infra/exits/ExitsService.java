package com.hotsix.infra.exits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExitsService {
	
	@Autowired
	ExitsDao dao;
	
	public List<ExitsDto> selectList(ExitsVo vo){
		
		return dao.selectList(vo);
	}
	
	public ExitsDto selectOne(ExitsDto dto) {
		return dao.selectOne(dto);
	}
	
	public int selectOneCount(ExitsVo vo) {
		
		return dao.selectOneCount(vo);
	}
	public int insert(ExitsDto dto) {
			
		dao.insert(dto);
//		dao.accountInsert(dto);
		
		return 1;
	}
	
	public int update(ExitsDto dto) {
		return dao.update(dto);
	}
	
	public int delete(ExitsDto dto) {
		return dao.delete(dto);
	}
	
	public int uelete(ExitsDto dto) {
		return dao.uelete(dto);
	}
	
	public List<ExitsDto> selectOrder(ExitsVo vo){
		return dao.selectOrder(vo);
	}
}
