<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑 설문조사 결과</title>
</head>
<body>

	<h1>캠핑 설문조사 결과</h1>
	<hr>
	
		<table>
			<tr>
				<td>이름</td>
				<td> <%= request.getParameter("userName") %></td>
			</tr>
			<tr>
				<td>평균 캠핑 기간</td>
				<td>
					<%= request.getParameter("period") %>
				</td>
			</tr>
			<tr>
				<td>캠핑 목적</td>
				<td>
					<%
						String[] purposes = request.getParameterValues("purpose");
						
						for(int i=0; i<purposes.length; i++){
							out.println(purposes[i]+"<br>");
						}
					%>
				</td>
			</tr>
			<tr>
				<td>캠핑 동반자</td>
				<td>
					<%
						String[] partners = request.getParameterValues("partner");
						
						for(int i=0; i<partners.length; i++){
							out.println(partners[i]+"<br>");
						}
					%>
				</td>
			</tr>
		</table>


</body>
</html>