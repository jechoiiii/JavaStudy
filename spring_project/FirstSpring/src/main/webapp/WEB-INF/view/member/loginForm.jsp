<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>

	<h1>Login Form </h1>
	
	<form method="POST"> <!-- GET 방식으로 들어오면 /member/login -->
		id <input type="text" name="uid"> <br>
		pw <input type="password" name="pw"> <br>
		<input type="submit">
	</form>
	
</body>
</html>