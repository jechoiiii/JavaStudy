<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:url value="/index.jsp" /> <br>
	<c:url value="index.jsp" /> <br>
	<c:url value="/index.jsp" var="indexLink" /> <br> <!-- url을 변수에 담음 -->
	${indexLink} <br>
	<c:url value="/index.jsp" >
		<c:param name="pageNumber" value="1" /> <!-- 변수를 따로 두지 않으면 그대로 출력 -->
		<c:param name="keyword" value="jstl" />
	</c:url>

</body>
</html>