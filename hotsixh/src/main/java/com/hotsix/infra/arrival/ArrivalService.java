package com.hotsix.infra.arrival;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalService {
	@Autowired
	ArrivalDao dao;
	
	public List<ArrivalDto> selectList(ArrivalVo vo){
		return dao.selectList(vo);
	}
	
	public ArrivalDto selectOne(ArrivalDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(ArrivalDto dto) {
		
		dao.insert(dto);
//		dao.companyInsert(dto);
		
		return 1;
	}
	
	public int update(ArrivalDto dto) {
		return dao.update(dto);
	}
	
	public int uelete(ArrivalDto dto) {
		return dao.uelete(dto);
	}
	
	public int delete(ArrivalDto dto) {
		return dao.delete(dto);
	}
	
	public int selectOneCount(ArrivalVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public List<ArrivalDto> placingOrderList(ArrivalDto dto){
		return dao.placingOrderList(dto);
	}
	
	public ArrivalDto placingOrderOne(ArrivalDto dto) {
		return dao.placingOrderOne(dto);
	}
}
