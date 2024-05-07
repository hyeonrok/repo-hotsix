package com.hotsix.infra.placingorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacingOrderService {
	@Autowired
	PlacingOrderDao dao;
	
	public List<PlacingOrderDto> selectList(PlacingOrderVo vo){
		return dao.selectList(vo);
	}
	
	public PlacingOrderDto selectOne(PlacingOrderDto dto) {
		return dao.selectOne(dto);
	}
	
	public int selectOneCount(PlacingOrderVo vo) {
		
		return dao.selectOneCount(vo);
	}
	public int insert(PlacingOrderDto dto) {
		
		dao.insert(dto);
//		dao.placingInsert(dto);
		return 1;
	}
	
	
	
	public int update(PlacingOrderDto dto) {
		return dao.update(dto);
	}
	
	public int delete(PlacingOrderDto dto) {
		return dao.delete(dto);
	}
	
	public int uelete(PlacingOrderDto dto) {
		return dao.uelete(dto);
	}

	
}
