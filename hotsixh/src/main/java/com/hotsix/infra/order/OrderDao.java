package com.hotsix.infra.order;

import java.util.List;

public interface OrderDao {

public List<OrderDto> selectList(OrderVo vo);
	
	public OrderDto selectOne(OrderDto dto);
	
	public int insert(OrderDto dto);
	
	public int insertMember(OrderDto dto);
	
	public int update(OrderDto dto);
	
	public int uelete(OrderDto dto);

	public int delete(OrderDto dto);
	
	public int selectOneCount(OrderVo vo);
}
