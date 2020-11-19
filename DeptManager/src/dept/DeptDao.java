package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// DAO : Data Access Object -> 데이터베이스 처리 기능만 가지는 클래스
public class DeptDao {
	
	// 싱글톤 
	private static DeptDao dao = new DeptDao();
	private DeptDao() {
	}
	public static DeptDao getInstance() {
		return dao;
	}
	

	// 부서 입력
	int insertDept(Dept dept, Connection conn) { // 참조받기
		
		int resultCnt=0;
	
		// DB 연결 : Connection
		try {
			// Statement (변수 없으면 Statement, 하나라도 있으면 Prepared 쓰자)
			// SQL : Insert into
			String sql = "insert into dept values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setNString(3, dept.getLoc());		
			
			// sql 실행
			resultCnt = pstmt.executeUpdate();		
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 결과
		return resultCnt;
	}

	
	
	
	// 부서 정보 수정
	int updateDept(Dept dept, Connection conn) { 

		int resultCnt=0;
		
		// DB 연결 : Connection
		try {
			// Statement (변수 없으면 Statement, 하나라도 있으면 Prepared 쓰자)
			// SQL : Update
			String sql = "update dept set dname=?, loc=? where deptno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, dept.getDeptno());
			pstmt.setString(1, dept.getDname());
			pstmt.setNString(2, dept.getLoc());		
			
			// sql 실행
			resultCnt = pstmt.executeUpdate();		
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 결과
		return resultCnt;
	}
	
	
	

	// 부서 정보 삭제
	int deleteDept(int deptno, Connection conn) {
		
		int resultCnt=0;
		
		// DB 연결 : Connection
		try {
			// Statement (변수 없으면 Statement, 하나라도 있으면 Prepared 쓰자)
			// SQL : delete
			String sql = "delete from dept where deptno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);	
			
			// sql 실행
			resultCnt = pstmt.executeUpdate();		
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 결과
		return resultCnt;
	}
	
	
	
	// 부서의 전체 리스트
	List<Dept> listDept(Connection conn) { // List<Dept> 타입
		
		//List<Dept> list = Collections.emptyList(); // 비어있는 인스턴스를 하나 만듬. --> 오류
		List<Dept> list = new ArrayList<Dept>();
		
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select * from dept order by deptno";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 목적이 List 보내기이기 때문에 굳이 정보가 없는 경우를 위해 조건 넣을 필요 X
				 //Dept d = new Dept(rs.getInt(1), rs.getString(2), rs.getNString(3));
				 //list.add(d); --> 더 간단하게
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getNString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	
	
	
	// 부서 하나 검색
	Dept searchDept(int deptno, Connection conn) { // deptno 받아서 검색, 부서 하나 검색하니까 List 아닌 Dept 타입으로
		
		Dept dept = null;
		
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select * from dept where deptno="+deptno;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			// 행 하나만 나오니 반복문 필요 X
			if(rs.next()) {
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return dept;		
	}
	
	
}
