<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="product" class="test.Product" scope="session" />
	<!-- Product product = new Product();
		session.setAttribute("product", product); 두 코드를 액션태그로 간단하게 사용 -->

	<%-- ${sessionScope.product} --%>
	
	<form action="selectProduct.jsp" method="post">
	
		<select name="sel">
			<%
				for(String item: product.getProductList() ) {
					out.println("<option>"+item+"</option>");
				}
			%>
		</select>
		<input type="submit" value="선택">
		
	</form>

</body>
</html>