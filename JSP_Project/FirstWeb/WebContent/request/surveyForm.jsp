<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑 설문조사</title>
</head>
<body>

	<h1>캠핑 설문조사</h1>
	<hr>
	
	<form action="surveyResult.jsp" method="get">
	
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td>평균 캠핑 기간</td>
				<td>
					<select name="period">
						<option value="6개월 미만">6개월 미만</option>
						<option value="6개월-1년 미만">6개월-1년 미만</option>
						<option value="1년-2년 미만">1년-2년 미만</option>
						<option value="2년-5년 미만">2년-5년 미만</option>
						<option value="5년 이상">5년 이상</option>
					</select>
				</td>
			</tr>
			<tr>  
				<td>캠핑 목적</td>
				<td>
					<input type="checkbox" name="purpose" value="가족 간의 화합 도모">가족 간의 화합 도모 <br>
					<input type="checkbox" name="purpose" value="스트레스 해소와 힐링">스트레스 해소와 힐링 <br>
					<input type="checkbox" name="purpose" value="지인들과의 친목">지인들과의 친목 <br>
					<input type="checkbox" name="purpose" value="자연 체험 활동">자연 체험 활동 <br>
					<input type="checkbox" name="purpose" value="혼자만의 시간">혼자만의 시간 <br>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>  
				<td>캠핑 시 동반자</td>
				<td>
					<input type="checkbox" name="partner" value="가족">가족<br>
					<input type="checkbox" name="partner" value="친구 및 선후배">친구 및 선후배<br>
					<input type="checkbox" name="partner" value="애인">애인<br>
					<input type="checkbox" name="partner" value="혼자">혼자<br>
					<input type="checkbox" name="partner" value="친인척">친인척<br>
					<input type="checkbox" name="partner" value="동호회/커뮤니티">동호회/커뮤니티<br>
					<input type="checkbox" name="partner" value="회사동료">회사동료<br>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="보내기"><input type="reset" value="초기화"></td>
				<td></td>
			</tr>
		</table>
	
	</form>

</body>
</html>