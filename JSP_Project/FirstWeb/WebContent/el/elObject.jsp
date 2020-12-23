<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("userName","김연아1");
	session.setAttribute("userName","김연아2");
	application.setAttribute("userName","김연아3");
	session.setAttribute("userId", "queen");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		<!-- 내장객체 표현식 생략 가능 -->
		<!-- 생략 시 규칙 : page > request > session > application 영역이 작은 순으로 찾는다. 가장 먼저 찾은 거 출력  -->
		requestScope.userName : ${requestScope.userName}, 
								${userName}, 
								<%= request.getAttribute("userName") %> <br>
								
		sessionScope.userId : ${sessionScope.userId}, 
							  ${userId},
							  <%= session.getAttribute("userId") %> <br>
							  
		param.code : ${param.code},
					 <%= request.getParameter("code") %>
					 
		pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %>, <br>
					  ${pageContext.request.requestURL} <br>
					  ${pageContext.request.requestURI} <br>
					  ${pageContext.request.contextPath}, <%= request.getContextPath() %>
	</h1>
	
	<a href="view1.jsp">session 페이지 확인</a>
</body>
</html>