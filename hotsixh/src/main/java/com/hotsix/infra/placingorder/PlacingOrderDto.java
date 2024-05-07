package com.hotsix.infra.placingorder;

import java.util.Date;

public class PlacingOrderDto {
	private String poSeq; 
	private String memberSeqF;
	private Date poRegDate; 
	private Date poModDate;
	private Integer poDelNy;
	private Integer poUseNy;
	private String poProductSeq;
	//수량
	private int poAccount;
	
	// 상품
	private String productName;
	private int productPrice;
	private Integer productTypeCd;
	private String productSeqF;
	private String poAccoint;
	
	//멤버
	private String memberName;
	private Integer memberTypeCd;
	private Integer genderCd;
	
	//주문
	private String orderSeqF;
	
	//poProduct
	private String poProductDelNy;
	private Date poProductRegDate;  
	private Date poProductModDate;
	
	
	
	public String getPoAccoint() {
		return poAccoint;
	}
	public void setPoAccoint(String poAccoint) {
		this.poAccoint = poAccoint;
	}
	public Date getPoProductRegDate() {
		return poProductRegDate;
	}
	public void setPoProductRegDate(Date poProductRegDate) {
		this.poProductRegDate = poProductRegDate;
	}
	public Date getPoProductModDate() {
		return poProductModDate;
	}
	public void setPoProductModDate(Date poProductModDate) {
		this.poProductModDate = poProductModDate;
	}
	public String getPoProductDelNy() {
		return poProductDelNy;
	}
	public void setPoProductDelNy(String poProductDelNy) {
		this.poProductDelNy = poProductDelNy;
	}
	public String getPoProductSeq() {
		return poProductSeq;
	}
	public void setPoProductSeq(String poProductSeq) {
		this.poProductSeq = poProductSeq;
	}
	public String getProductSeqF() {
		return productSeqF;
	}
	public void setProductSeqF(String productSeqF) {
		this.productSeqF = productSeqF;
	}
	public String getOrderSeqF() {
		return orderSeqF;
	}
	public void setOrderSeqF(String orderSeqF) {
		this.orderSeqF = orderSeqF;
	}
	public Integer getGenderCd() {
		return genderCd;
	}
	public void setGenderCd(Integer genderCd) {
		this.genderCd = genderCd;
	}
	public int getPoAccount() {
		return poAccount;
	}
	public void setPoAccount(int poAccount) {
		this.poAccount = poAccount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductTypeCd() {
		return productTypeCd;
	}
	public void setProductTypeCd(Integer productTypeCd) {
		this.productTypeCd = productTypeCd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getMemberTypeCd() {
		return memberTypeCd;
	}
	public void setMemberTypeCd(Integer memberTypeCd) {
		this.memberTypeCd = memberTypeCd;
	}
	public String getPoSeq() {
		return poSeq;
	}
	public void setPoSeq(String poSeq) {
		this.poSeq = poSeq;
	}
	public String getMemberSeqF() {
		return memberSeqF;
	}
	public void setMemberSeqF(String memberSeqF) {
		this.memberSeqF = memberSeqF;
	}
	public Date getPoRegDate() {
		return poRegDate;
	}
	public void setPoRegDate(Date poRegDate) {
		this.poRegDate = poRegDate;
	}
	public Date getPoModDate() {
		return poModDate;
	}
	public void setPoModDate(Date poModDate) {
		this.poModDate = poModDate;
	}
	public Integer getPoDelNy() {
		return poDelNy;
	}
	public void setPoDelNy(Integer poDelNy) {
		this.poDelNy = poDelNy;
	}
	public Integer getPoUseNy() {
		return poUseNy;
	}
	public void setPoUseNy(Integer poUseNy) {
		this.poUseNy = poUseNy;
	}
	
	
	
	
	
}
