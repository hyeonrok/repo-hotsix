package com.hotsix.infra.product;

import java.util.List;

public interface ProductDao {
	
public List<ProductDto> selectList(ProductVo vo);
	
	public List<ProductDto> companyList(ProductVo vo);
	
	public ProductDto selectOne(ProductDto dto);
	
	public ProductDto memberOne(ProductDto dto);
	
	public int selectOneCount(ProductVo vo);
	
	public int insert(ProductDto dto);
	
	public int update(ProductDto dto);
	
	public int uelete(ProductDto dto);

	public int delete(ProductDto dto);
	
	public List<ProductDto> productList(ProductVo vo);

}
