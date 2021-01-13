package com.aia.op.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegRequest {

	private String userid;
	private String pw;
	private String username;
	private MultipartFile userphoto;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MultipartFile getUserphoto() {
		return userphoto;
	}
	public void setUserphoto(MultipartFile userphoto) {
		this.userphoto = userphoto;
	}
	
	
	public Member toMember() {
		Member member = new Member();
		member.setMemberid(userid);
		member.setMembername(username);
		member.setPassword(pw);
		
		return member;
	}
	
	
	@Override
	public String toString() {
		return "MemberRegRequest [userid=" + userid + ", pw=" + pw + ", username=" + username + ", userphoto="
				+ userphoto.getOriginalFilename() + "]";
	}
	
}
