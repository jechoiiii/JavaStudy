<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1. 선택한 상품 : ${param.sel} <br>
	2. 상품 설명 : ${product.display} ==> product.getDisplay() <br> <!-- 매서드 호출, 변수를 부르는게 X --> 
	3. 상품 : ${product.productList[0]}
</body>
</html>