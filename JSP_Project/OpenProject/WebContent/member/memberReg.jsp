<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	int result = 0;

	// DAO 객체의 insert 메서드로 member 참조변수 전달, Coonection 객체의 참조변수 전달 
	
	Connection conn = ConnectionProvider.getConnection();


	//MemberDao dao = new MemberDao(); -> 외부에서 사용 불가 
	MemberDao dao = MemberDao.getInstance();
	
	if(conn != null) {
		
		// 폼에 입력한 사용자 데이터의 한글 처리
		// request.setCharacterEncoding("utf-8");
	
		String userId = request.getParameter("userid"); 
		String password = request.getParameter("pw");
		String userName = request.getParameter("name");
		String userPhoto = request.getParameter("photo");
		
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(password);
		member.setUserName(userName);
		member.setUserPhoto(userPhoto);
		
		System.out.println(member);
		
		// DB 에 데이터 저장
		result = dao.insertMember(conn, member);
	}
	
	request.setAttribute("result", result);
	
%>
<jsp:forward page="memberReg_view.jsp"/>
