package com.hotsix.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {
	private String codeGroupSeq; 
	private String codeGroupName; 
	private Date codeGroupRegDate;
	private Date codeGroupModDate; 
	private Integer codeGroupDelNy; 
	private Integer codeGroupUseNy;
	
	
	public String getCodeGroupSeq() {
		return codeGroupSeq;
	}
	public void setCodeGroupSeq(String codeGroupSeq) {
		this.codeGroupSeq = codeGroupSeq;
	}
	public String getCodeGroupName() {
		return codeGroupName;
	}
	public void setCodeGroupName(String codeGroupName) {
		this.codeGroupName = codeGroupName;
	}
	public Date getCodeGroupRegDate() {
		return codeGroupRegDate;
	}
	public void setCodeGroupRegDate(Date codeGroupRegDate) {
		this.codeGroupRegDate = codeGroupRegDate;
	}
	public Date getCodeGroupModDate() {
		return codeGroupModDate;
	}
	public void setCodeGroupModDate(Date codeGroupModDate) {
		this.codeGroupModDate = codeGroupModDate;
	}
	public Integer getCodeGroupDelNy() {
		return codeGroupDelNy;
	}
	public void setCodeGroupDelNy(Integer codeGroupDelNy) {
		this.codeGroupDelNy = codeGroupDelNy;
	}
	public Integer getCodeGroupUseNy() {
		return codeGroupUseNy;
	}
	public void setCodeGroupUseNy(Integer codeGroupUseNy) {
		this.codeGroupUseNy = codeGroupUseNy;
	}
	
	
	
	
}
