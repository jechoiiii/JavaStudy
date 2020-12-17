<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    	Member member = (Member) request.getAttribute("regInfo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 데이터 출력</title>
</head>
<body>

	<h1>회원가입이 완료되었습니다.</h1>
	<hr>
	<h3>
		ID : <%= member.getUserid() %> <br>
		PW : <%= member.getPw() %> <br>
		Name : <%= member.getName() %> <br>
		Photo : <%= member.getPhoto() %>
	</h3>
	
</body>
</html>