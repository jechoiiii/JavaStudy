<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Frame Include</title>
	<style>
		div.header {
			text-align: center;
		}
		
		div.nav {
			text-align: center;
		}
		
		div.news, div.shopping {
			width: 45%;
		}
		
		div.news {
			float: left;
			
		}
		
		div.shopping {
			float: right;
		}
		
		div.footer {
			clear: both;
			text-align: center;
		}
		
	</style>
</head>
<body>

<%@ include file="header.jsp" %>
	
<%@ include file="navi.jsp" %>
	
	<div class="contents">
<%@ include file="news.jsp" %>
<%@ include file="shopping.jsp" %>
	</div>
	
	<%-- <jsp:include page="footer.jsp">
 		<jsp:param value="cool@gmail.com" name="email"/>
 		<jsp:param value="010-1111-2222" name="tel"/>
 	</jsp:include> --%>
 	
 	<!-- forward : forward한 footer.jsp의 실행결과를 index.jsp의 응답으로 처리. 위 코드 전부 무시 -->
 	<jsp:forward page="footer.jsp">
 		<jsp:param value="cool@gmail.com" name="email"/>
 		<jsp:param value="010-1111-2222" name="tel"/>
 	</jsp:forward>

<%-- <%@ include file="footer.jsp" %> --%>
	
</body>
</html>