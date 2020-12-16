<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("userName", "김연아");
	application.setAttribute("userId", "1111");	
	session.setAttribute("nickName", "QUEEN");	
	pageContext.setAttribute("age", 28);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= request.getAttribute("userName") %>,
	<%= application.getAttribute("userId") %>,
	<%= session.getAttribute("nickName") %>,
	<%= pageContext.getAttribute("age") %>
	

</body>
</html>