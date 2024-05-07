package com.hotsix.infra.member;

import java.util.Date;

public class MemberDto {
	
	private String memberSeq;
	private String memberName;
	private String memberId;
	private String memberPwd;
	private Integer genderCd;
	private String phoneNumber;
	private Integer memberTypeCd;
	private Date memberRegDate;
	private Date memberModDate;
	private Integer memberDelNy;
	
	private String companySeq;
	private String companyName;
	private String companySeqF;
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public Integer getGenderCd() {
		return genderCd;
	}
	public void setGenderCd(Integer genderCd) {
		this.genderCd = genderCd;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getMemberTypeCd() {
		return memberTypeCd;
	}
	public void setMemberTypeCd(Integer memberTypeCd) {
		this.memberTypeCd = memberTypeCd;
	}
	public Date getMemberRegDate() {
		return memberRegDate;
	}
	public void setMemberRegDate(Date memberRegDate) {
		this.memberRegDate = memberRegDate;
	}
	public Date getMemberModDate() {
		return memberModDate;
	}
	public void setMemberModDate(Date memberModDate) {
		this.memberModDate = memberModDate;
	}
	public Integer getMemberDelNy() {
		return memberDelNy;
	}
	public void setMemberDelNy(Integer memberDelNy) {
		this.memberDelNy = memberDelNy;
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
	public String getCompanySeqF() {
		return companySeqF;
	}
	public void setCompanySeqF(String companySeqF) {
		this.companySeqF = companySeqF;
	}
	
	
}
