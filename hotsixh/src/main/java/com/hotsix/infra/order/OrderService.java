package com.hotsix.infra.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderDao dao;
	
	public List<OrderDto> selectList(OrderVo vo) {
		
		return dao.selectList(vo);
	}
	
	public OrderDto selectOne(OrderDto dto) {
		
		return dao.selectOne(dto);
	}
	
	public int insert(OrderDto dto) {

		dao.insert(dto);
		dao.insertMember(dto);
		
		return 1;
				
	}
	
	public int update(OrderDto dto) {
			 dao.update(dto); 
	return 1;	
	}
	
	public int uelete(OrderDto dto) {
		
		return dao.uelete(dto);
	}
	
	public int delete(OrderDto dto) {
		
		return dao.delete(dto);
	}
	
	public int selectOneCount(OrderVo vo) {
		return dao.selectOneCount(vo);
	}
}
