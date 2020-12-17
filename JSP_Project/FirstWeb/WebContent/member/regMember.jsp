<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// 사용자가 입력한 데이터를 한글 처리
	request.setCharacterEncoding("UTF-8");

	// 사용자로부터 데이터 받기 (request)
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String photo = request.getParameter("photo");
	
	// beans 객체 생성
	Member member = new Member();
	
	// beans에 데이터 바인딩 (저장)
	member.setUserid(userid);	
	member.setPw(pw); 		 
	member.setName(name);		
	member.setPhoto(photo);		 
	
	// beans를 request 내장 객체의 속성에 저장 -> view 페이지에 데이터 공유(전달) 
	request.setAttribute("regInfo", member);
	
	// view 페이지로 forwarding
%>

<jsp:forward page="regMember_view.jsp"/>