<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Index</h1>
	<c:url value="/hello" var="hello"/>
	
	<ul> 
		<li>
			<c:url value="/hello" var="hello"/> <!-- 코어 태그는 value 속성을 사용했기 때문에 출력되지 X -->
			<a href="${hello}">${hello}</a>
		</li>
		<li>
			<c:url value="/member/login" var="login"/> 
			<a href="${login}">${login}</a>
		</li>
		<li>
			<c:url value="/member/search" var="search"/> 
			<a href="${search}">${search}</a>
		</li>
		<li>
			<c:url value="/order/order" var="order"/> 
			<a href="${order}">${order}</a>
		</li>
	</ul>

</body>
</html>
