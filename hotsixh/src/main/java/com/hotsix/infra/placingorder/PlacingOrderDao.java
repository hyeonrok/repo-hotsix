package com.hotsix.infra.placingorder;

import java.util.List;

public interface PlacingOrderDao {
	
	public List<PlacingOrderDto> selectList(PlacingOrderVo vo);
	
	public PlacingOrderDto selectOne(PlacingOrderDto dto);
	
	public int selectOneCount(PlacingOrderVo vo);
	
	public int insert(PlacingOrderDto dto);
	
	public int placingInsert(PlacingOrderDto dto);
	
	public int update(PlacingOrderDto dto);
	
	public int uelete(PlacingOrderDto dto);
	
	public int delete(PlacingOrderDto dto);
	
	
}
