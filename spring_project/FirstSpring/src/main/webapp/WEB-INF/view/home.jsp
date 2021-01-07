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
			<!-- 코어 태그는 value 속성을 사용했기 때문에 출력되지 X -->
			<c:url value="/hello" var="hello"/> 
			<a href="${hello}">${hello}</a>
		</li>
	</ul>

</body>
</html>
