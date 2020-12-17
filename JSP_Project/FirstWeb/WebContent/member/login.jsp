<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 사용자로부터 받은 데이터를 beans에 저장
	
	// 사용자로부터 데이터 받기 (request)
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	// beans 객체 생성
	Member member = new Member();

	// beans에 데이터 바인딩 
	member.setUserid(userid);	
	member.setPw(pw); 			
	
	// 데이터 공유 : request 속성을 이용해 beans 객체 전달 
	request.setAttribute("login", member);
	
	// login_view.jsp로 포워딩 
%>

<jsp:forward page="login_view.jsp"/>