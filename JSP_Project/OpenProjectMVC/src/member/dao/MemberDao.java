package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.model.Member;

public class MemberDao {

	// 싱글톤 패턴 (코딩 스타일) 
	// 외부에서 인스턴스를 생성하지 못한다. 
	// 인스턴스를 반환해주는 메서드가 있어 인스턴스가 필요한 경우 메서드를 이용해서 얻는다. 
	
	// 인스턴스 생성을 막는다. 생성자의 접근제어자 -> private 
	private MemberDao() {}
	
	// 객체 하나를 생성해서 사용한다.
	private static MemberDao dao = new MemberDao();
	
	// Dao 객체의 참조변수를 반환해주는 메서드 : 외부 클래스 누구나 접근해서 사용 가능해야 한다. 
	public static MemberDao getInstance() {
		return dao;
	}
	
	// Member 테이블의 Data 를 CRUD
	// insert, select, update, delete
	
	// 데이터 입력 
	public int insertMember(Connection conn, Member member) {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sqlInsert = "INSERT INTO member (memberid, password, membername, memberphoto) values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserPhoto());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	// 로그인을 위한 select 
	public Member selectMemberLogin(Connection conn, String uid, String pw) throws SQLException {
		
		Member member = null;
		
		String sqlSelect = "SELECT * FROM member where memberid=? and password=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setString(1, uid);
			pstmt.setString(2, pw);
			
			ResultSet rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				member = makeMember(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	
	// 전체 리스트를 반환하는 select
	public List<Member> selectMember(Connection conn){
		
		List<Member> list = new ArrayList<Member>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(makeMember(rs));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	// 멤버 객체를 리스트에 저장 
	public List<Member> selectMember(Connection conn, int firstRow, int count) throws SQLException {

		List<Member> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member ORDER BY memberid limit ?,?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			memberList = new ArrayList<Member>();
			
			while(rs.next()) {
				memberList.add(makeMember(rs));
			}	
			
		} finally {
			rs.close();
			pstmt.close();
		}

		
		return memberList;
	}
	
	
	// 중복 코드 메서드로 변경 
		private Member makeMember(ResultSet rs) throws SQLException {
			return new Member(
					rs.getString("memberid"),
					rs.getString("password"),
					rs.getString("membername"),
					rs.getString("memberphoto"),
					rs.getTimestamp("regdate"));
		}
	
	
	// 전체 회원의 수
		public int selectMemberTotalCount(Connection conn) throws SQLException {
			
			int resultCnt = 0;
			Statement stmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT count(*) FROM member";
			
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					resultCnt = rs.getInt(1);
				}
				
			} finally {
				rs.close();
				stmt.close();
			}
			
			return resultCnt;
		}
	
}
