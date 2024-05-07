package com.hotsix.infra.company;

import java.util.Date;

public class CompanyDto {
	
	private String companySeq; 
	private String companyName; 
	private String companyNumber; 
	private Date companyRegDate; 
	private Date companyModDate; 
	private Integer companyDelNy; 
	private Integer companyUsrNy;
	
	private String arrivalSeq;
	
	
	
	public String getArrivalSeq() {
		return arrivalSeq;
	}
	public void setArrivalSeq(String arrivalSeq) {
		this.arrivalSeq = arrivalSeq;
	}
	public String getCompanySeq() {
		return companySeq;
	}
	public void setCompanySeq(String companySeq) {
		this.companySeq = companySeq;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	public Date getCompanyRegDate() {
		return companyRegDate;
	}
	public void setCompanyRegDate(Date companyRegDate) {
		this.companyRegDate = companyRegDate;
	}
	public Date getCompanyModDate() {
		return companyModDate;
	}
	public void setCompanyModDate(Date companyModDate) {
		this.companyModDate = companyModDate;
	}
	public Integer getCompanyDelNy() {
		return companyDelNy;
	}
	public void setCompanyDelNy(Integer companyDelNy) {
		this.companyDelNy = companyDelNy;
	}
	public Integer getCompanyUsrNy() {
		return companyUsrNy;
	}
	public void setCompanyUsrNy(Integer companyUsrNy) {
		this.companyUsrNy = companyUsrNy;
	}   
	
	
	
}
