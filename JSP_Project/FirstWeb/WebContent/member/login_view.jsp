<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    	Member member = (Member) request.getAttribute("login");
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 데이터 출력</title>
</head>
<body>

	<h1>로그인 되었습니다.</h1>
 	<h3><%= member.getUserid() %> ( <%= member.getPw() %> ) </h3>
 	<h3><a href="loginSessionCheck.jsp">로그인 여부 체크 페이지 </a></h3>

</body>
</html>