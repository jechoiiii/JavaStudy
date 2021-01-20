package com.aia.firstspring.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id", "message", "regDate"})
public class GuestMessage2 {

	private int id;
	private String message;
	private Date regDate;
	
	
	public GuestMessage2() {
	}

	public GuestMessage2(int id, String message, Date regDate) {
		this.id = id;
		this.message = message;
		this.regDate = regDate;
	}

	public int getId2() {
		return id;
	}
	public void setId2(int id) {
		this.id = id;
	}
	public String getMessage2() {
		return message;
	}
	public void setMessage2(String message) {
		this.message = message;
	}
	public Date getRegDate2() {
		return regDate;
	}
	public void setRegDate2(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
