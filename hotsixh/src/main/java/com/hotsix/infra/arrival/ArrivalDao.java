package com.hotsix.infra.arrival;

import java.util.List;

public interface ArrivalDao {
	
	public List<ArrivalDto> selectList(ArrivalVo vo);
	
	public ArrivalDto selectOne(ArrivalDto dto);
	
	public int insert(ArrivalDto dto);
	
	public int companyInsert(ArrivalDto dto);
	
	public int update(ArrivalDto dto);
	
	public int uelete(ArrivalDto dto);
	
	public int delete(ArrivalDto dto);
	
	public int selectOneCount(ArrivalVo vo);
	
	public List<ArrivalDto> placingOrderList(ArrivalDto dto);
	
	public ArrivalDto placingOrderOne(ArrivalDto dto);
}
