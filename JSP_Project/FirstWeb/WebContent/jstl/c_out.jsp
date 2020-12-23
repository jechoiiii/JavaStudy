<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ include file="makeList.jsp" %> <!-- 화면 모듈화뿐 아니라 코드 모듈화도 가능! -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 리스트 </h1>
	
	<table border="1">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>아이디</th>
			<th>비밀번호 </th>
			<th>이름 </th>
			<th>사진</th>
		</tr>
		
		<!-- index, count -->
		<c:forEach items="${members}" var="member" varStatus="status"> 
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${member.userid} </td>
				<td>${member.pw} </td>
				<td>${member.name}</td>
				<td>
					<c:out value="${member.photo}" escapeXml="false"> <!-- false처리 : span이 html 형태로 들어간다 -->
						<span style="color:red;">프로필 사진 없음 </span> <!-- value가 null/공백일 때 -->
					</c:out>
					
				</td>
			</tr>
		</c:forEach>	
	</table>
	
	
	<br>
	<c:forEach var="num" begin="1" end="10" step="1">
		${num} <br>
	</c:forEach>
	
	

</body>
</html>