<%@page import="form.MemberData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 사용자로부터 받은 데이터를 beans에 저장
	//	  beans 객체 생성
	MemberData loginFormData = new MemberData();

	//	  사용자로부터 데이터 받기 (request)
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	//    beans에 데이터 저장 
	loginFormData.setUserid(userid);	// id 저장 
	loginFormData.setPw(pw); 			// pw 저장 
	
	// 2. login_view.js 으로 beans 객체 전달/공유 
	request.setAttribute("data", loginFormData);
%>

<!-- 페이지 이동 -->  
<jsp:forward page="loginView.jsp"/>