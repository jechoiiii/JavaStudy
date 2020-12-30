<%@page import="member.service.MemberLoginService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 사용자 요청에 맞는 서비스 클래스의 인스턴스 생성 -> 메서드 실행 
	// 사용자 요청에 맞는 View 를 선택해서 Forward 
	// ( 핵심처리는 모두 MemberLoginService.java 로 이동 )
	MemberLoginService service = MemberLoginService.getInstance();
	service.memberLogin(request, response);

%>
<jsp:forward page="login_view.jsp"/>
