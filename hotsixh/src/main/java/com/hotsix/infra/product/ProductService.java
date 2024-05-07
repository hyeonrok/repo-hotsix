package com.hotsix.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;
	
	public List<ProductDto> selectList(ProductVo vo) {
		
		return dao.selectList(vo);
	}
	
	public List<ProductDto> companyList(ProductVo vo){
		
		return dao.companyList(vo);
	}
	
	public ProductDto selectOne(ProductDto dto) {
	
		return dao.selectOne(dto);
	}
	
	public ProductDto memberOne(ProductDto dto) {
		
		return dao.memberOne(dto);
	}

	public int selectOneCount(ProductVo vo) {
		
		return dao.selectOneCount(vo);
	}
	
	public int insert(ProductDto dto) {
		
		return dao.insert(dto);
	}
	
	public int update(ProductDto dto) {
			
			return dao.update(dto);
		}
	
	public int uelete(ProductDto dto) {
		
		return dao.uelete(dto);
	}
	
	public int delete(ProductDto dto) {
		
		return dao.delete(dto);
	}
	
	public List<ProductDto> productList(ProductVo vo){
		return dao.productList(vo);
	}
	
}
