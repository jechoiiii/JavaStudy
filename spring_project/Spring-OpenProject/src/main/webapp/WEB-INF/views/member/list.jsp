<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>회원 리스트 </title>
 <%@ include file="/WEB-INF/views/include/basicset.jsp" %>
 <style>
 
 	.table {
 		/* border: 1px solid #DDD; */
 		width: 100%;
 	}
 	
 	td, th {
 		border-bottom: 1px solid #DDD;
 		text-align: center;
 		padding: 5px 0;
 	}
 
 	.nowpage {
 		font-size: 1.5em;
 		font-weight: bold;
 	}
 	
 	.paging {
 		text-align: center;
 	}
 
 </style>
 </head>
 <body>
 	<%@ include file="/WEB-INF/views/include/header.jsp"%>
 	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

 	<div class="contents">
 		<h2 class="content_title">회원 리스트 </h2>
 		<hr>
 		<div class="content"> 
 			
 			<table class="table">
 				<tr>
 					<th>idx</th>
 					<th>Member ID</th>
 					<th>Member Name</th>
 					<th>Member Photo</th>
 					<th>Member RegistDate</th>
 				</tr>
 				
 				<c:forEach items="${listView.memberList}" var="member">
				<tr>
					<td>${member.idx}</td>
					<td>${member.memberid}</td>
					<td>${member.membername}</td>
					<td> 
						<img height="30" alt="프로필 사진" src="<c:url value="/fileupload/member/${member.memberphoto}"/>">
					</td>
					<td>
						<fmt:formatDate value="${member.regdate}" pattern="yyyy.MM.dd"/>
					</td>
				</tr>
 				</c:forEach>
 			</table>
 			
 			<div class="paging">
 				<c:if test="${listView.totalMemberCount>0}">
				<c:forEach begin="1" end="${listView.totalPageCount}" var="num">
				[ <a href="<c:url value="/member/list"/>?p=${num}" 
					 class="${listView.pageNumber eq num ? 'nowpage' : ''}"> ${num} </a> ] 
				</c:forEach>
 				</c:if>
 			</div>
 			
 		</div>
 	</div>

 	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

 </body>
 </html> 